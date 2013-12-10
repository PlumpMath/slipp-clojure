(ns study.stringcalculator
  (:require [clojure.string :refer [split]]))

(defn add [text]
  (reduce
    +
    (map #(Integer/parseInt %)
      (enumerate-string text)))
)

(defn result [text]
  (first (re-seq #"//(.)\n(.*)" text) ))

(defn enumerate-string [text]
  (defn enumerate-string-iter [text delimeter]
    (cond (= text "") '("0")
          (.startsWith text "//")
            (let [result-values (result text)]
              (enumerate-string-iter (nth result-values 2) (nth result-values 1)))
          :else
            (split text (re-pattern delimeter))))
  (enumerate-string-iter text ",|\n"))















