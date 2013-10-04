(ns guestbook.routes.home
  (:require [compojure.core :refer :all]
            [hiccup.form :refer :all]
            [guestbook.views.layout :as layout]
            [guestbook.models.db :as db]))

(defn home [& [name message error]]
  (layout/common
    [:h1 "Guestbook!"]
    [:p "이곳은 안부 게시판"]
    [:p error]

    (show-guests)

    (form-to [:post "/"]
      [:p "Name:"]
      (text-field "name" name)

      [:p "Message:"]
      (text-area {:rows 10 :cols 40} "message" message)
      [:br]

      (submit-button "comment"))))

(defn show-guests []
  [:ul.guests
    (for [{:keys [message name timestamp]} (db/read-guests)]
         [:li
           [:blockquote message]
          [:p "-" [:cite name]]
          [:time (format-time timestamp)]])])

(defn format-time [timestamp]
  (.format (java.text.SimpleDateFormat. "MM/dd/yyyy") timestamp))

(defroutes home-routes
  (GET "/" [] (home))
  (POST "/" [name message] (save-message name message)))

(defn save-message [name message]
  (cond
    (empty? name)
    (home name message "Some dummy forgot to leave a name")

    (empty? message)
    (home name message "Don't you have something to say?")

    :else
    (do
      (db/insert-message name message)
      (home))))
