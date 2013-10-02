(ns example.core
  (:use compojure.core)
  (:require
    [compojure.route :as route]
    [ring.adapter.jetty :as jetty]
    [ring.middleware.params :as params]
    [clostache.parser :as clostache]
    [example.jdbc]))

; Template Rendering
(defn read-template [template-name]
  (slurp (clojure.java.io/resource (str "templates/" template-name ".mustache"))))

(defn render-template [template-file params]
   (clostache/render (read-template template-file) params))

; Controller functions
(defn index []
  (render-template "index" {:greeting "Bonjour"}))

(defn form []
  (render-template "form" {}))

(defn create [title contents]
  (render-template "create"
     {:title title :contents contents}))

; Routing
(defroutes main-routes
  (GET "/" [] (index))
  (GET "/form" [] (form))
  (POST "/" [title contents] (create title contents))
  (route/resources "/")
  (route/not-found "404 Not Found"))

(def app (params/wrap-params main-routes))

; Server
(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "5000"))]
    (jetty/run-jetty app {:port port})))

