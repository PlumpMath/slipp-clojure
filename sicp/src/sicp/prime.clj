(defn square [x] (* x x))

(defn divides? [a b]
  (= (rem b a) 0))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn find-divisor [n test-divisor]
  (cond (> (square test-divisor) n) n
        (divides? test-divisor n) test-divisor
        :else (find-divisor n (+ test-divisor 1))))

(defn prime? [n]
  (= n (smallest-divisor n)))


(defn sum-primes [a b]
  (defn iter [count accum]
      (cond (> count b) accum
            (prime? count) (iter (+ count 1) (+ count accum))
            :else (iter (+ count 1) accum)))

  (iter a 0))

(sum-primes 0 10)
(sum-primes 100 1000)
(sum-primes 100 5000)
