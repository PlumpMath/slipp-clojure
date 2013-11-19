(defn square [x] (* x x))

(defn fast-expt [b n]
  (cond (= n 0) 1
        (even? n) (square (fast-expt b (/ n 2)))
        :else (* b (fast-expt b (- n 1)))))

(fast-expt 2 10)

(defn square [x] (* x x))

(defn halve [x] (/ x 2))

(defn fast-expt-iter [b n a]
  (cond (= n 0) a
        (even? n) (fast-expt-iter (square b) (/ n 2) a)
        :else (fast-expt-iter b (- n 1) (* a b))
        ))

(fast-expt-iter 2 1 1)

(fast-expt-iter 2 2 1)

(fast-expt-iter 2 3 1)

(fast-expt-iter 2 4 1)
