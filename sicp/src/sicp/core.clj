(ns sicp.core)

(defn abs [x]
  (if (< x 0) (- x) x))

(defn square [x] (* x x))

(defn cubic [x] (* x x x))

(defn sum-of-squares [x y] (+ (square x) (square y)))

(defn average [x y] (/ (+ x y) 2))

(defn sqrt [x]
  (defn improve [guess]
    (average guess (/ x guess)))
  (defn good-enough? [guess prev-guess]
    (< (/ (abs (- guess prev-guess)) guess) 0.001))
  (defn sqrt-iter [guess prev-guess]
    (if (good-enough? guess prev-guess) guess
      (sqrt-iter (improve guess) guess)))
  (sqrt-iter 1.0 0.0))


(defn improve-cube [guess x]
  (/ (+ (/ x (square guess)) (* 2 guess)) 3))

(defn cube-root-iter [guess prev-guess x]
  (if (good-enough? guess prev-guess) guess
    (cube-root-iter (improve-cube guess x) guess x)))

(defn cube-root [x]
  (cube-root-iter 1.0 0.0 x))







