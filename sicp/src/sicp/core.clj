(ns sicp.core)

(defn abs [x]
  (if (< x 0) (- x) x))

(defn square [x] (* x x))

(defn sum-of-squares [x y] (+ (square x) (square y)))

(defn average [x y] (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough? [guess x]
  (< (- (square guess) x) 0.001))

