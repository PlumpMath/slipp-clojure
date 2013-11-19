(defn exer-1-11 [n]
  (if (< n 3) n
    (+ (exer-1-11 (- n 1)) (* 2 (exer-1-11 (- n 2))) (* 3 (exer-1-11 (- n 3))))))

(exer-1-11 2)

(exer-1-11 3)

(exer-1-11 4)

(exer-1-11 5)

(exer-1-11 6)

(exer-1-11 7)

(exer-1-11 20)


(defn exer [n]
  (defn exer-iter [product n]
    (if (< n 3) product
        (exer-iter (+
                    (exer-iter product (- n 1))
                    (* 2 (exer-iter product (- n 2)))
                    (* 3 (exer-iter product (- n 3))))
                   (- n 1))))
  (if (< n 3) n
    (exer-iter 0 n)))

(exer 2)

(exer 3)

(exer 4)

(exer 5)

(exer 6)

(exer 7)

