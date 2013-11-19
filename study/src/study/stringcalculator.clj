(ns study.stringcalculator
  (:require [clojure.string :refer [split]]))

(defn add [text]
  (defn add-iter [text delimter]
    (cond
      (= text "") 0
      (.startsWith text "//")
        (let [result-values (result text)]
          (add-iter (nth result-values 2) (nth result-values 1)))
      :else
        (reduce +
          (map #(Integer/parseInt %)
            (split text (re-pattern delimter))))
    ))

  (add-iter text ",|\n")
)

(defn result [text]
  (first (re-seq #"//(.)\n(.*)" text) ))












