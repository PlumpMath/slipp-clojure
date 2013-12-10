; exercise 2.37

(defn dot-product
  [v w]
  (accumulate + 0 (map * v w)))

(dot-product [1 2] [3 4])



; exercise 2.36
(defn accumulate-n
  [op init seqs]
  (if (empty? (first seqs))
    ()
    (cons (accumulate op init (map first seqs))
          (accumulate-n op init (map rest seqs)))))

(accumulate-n + 0 [[1 2 3] [4 5 6] [7 8 9] [10 11 12]])

(accumulate-n + 0 (list '(1 2 3) '(4 5 6) '(7 8 9)))

; exercise 2.35
(defn old-count-leaves
  [items]
  (cond
    (not (seq? items)) 1
    (empty? items) 0
    :else (+ (old-count-leaves (first items))
             (old-count-leaves (rest items)))))

(old-count-leaves (list (list 1 2) 3 4))


; exercise 2.34
(defn horner-eval [x coefficient-sequecne]
  (accumulate  #(+ (* %2 x) %1) 0 coefficient-sequecne))

(horner-eval 2 (list 1 3 0 5 0 1))


; 152 page => tree에서 모든 leaf를 꺼내는 fuction

(conj (list 1 2 3 4) 5) ; (conj coll element & elements)

(defn my-append
  [list1 list2]
  (if (empty? list1)
    list2
    (cons (first list1) (my-append (rest list1) list2))))

(defn enumerate-tree
  [tree]
  (cond
   (not (seq? tree)) (list tree)
   (empty? tree) nil
   :else (my-append (enumerate-tree (first tree))
                 (enumerate-tree (rest tree)))))

(enumerate-tree (list (list 2 3) 4 5))

(defn accumulate
  [op initial sequence]
  (if (empty? sequence)
    initial
    (op (first sequence)
        (accumulate op initial (rest sequence)))))


(defn my-map
  [p sequence]
  (accumulate (fn [x y] (conj y (p x))) () sequence))

(my-map #(* % %) (list 1 2 3 4))

(defn append [seq1 seq2]
  (accumulate cons seq2 seq1)
  )

(append (list 1 2 3) (list 4 5 6))

(defn length [sequence]
  (accumulate #(inc %2) 0 sequence)
  )

(length (list 1 2 3 4))



(def x (cons (list 1 2) (list 3 4)))

(defn length [values]
  (defn length-iter [values size]
    (if (empty? values) size
        (length-iter (rest values) (+ size 1))
      ))
  (length-iter values 0)
  )

(t (length x) 3)


(defn pair? [values]
  (= (length values) 2))

(t (pair? nil) false)
(t (pair? (list 1)) false)
(t (pair? (list 1 2)) true)
(t (pair? (list 1 2 3)) false)


(defn last-pair [values]
  (if (empty? (rest values)) (first values)
      (last-pair (rest values)))
  )

(last-pair (list 1))

(last-pair (list 2 3))


(defn my-reverse [values]
  (if (empty? values) '()
      (conj (my-reverse (rest values)) (first values))
    ))

(my-reverse (list 1 2 3 4))




(defn t [actual expected]
    (if (= actual expected)
        (do
           (println 'sucess)
         true )
       (do
           (println (str 'fail!! " actual: " actual " expected " expected ))
         false)))
(t 1 1)
(t 1 0)





