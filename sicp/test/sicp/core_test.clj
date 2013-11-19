(ns sicp.core-test
  (:require [clojure.test :refer :all]
            [sicp.core :refer :all]))

(deftest test-abs
  (testing "abs"
    (is (= 3 (abs 3))))
    (is (= 3 (abs (- 3))))
)

(deftest test-square
  (testing "square"
    (is (= 9 (square 3))))
)

(deftest test-sum-of-squares
  (testing "sum of squares"
    (is (= 25 (sum-of-squares 3 4))))
)

(deftest test-average
  (testing "average"
    (is (= 1.5 (average 1.0 2))))
)

(deftest test-improve-cube
  (testing "improve cube"
    (is (good-enough? 1.6666 (improve-cube 1.0 3)))))

(run-tests)

(sqrt 3)

(sqrt 7)

(cube-root 1.0)

(cube-root 2.0)

(cubic 1.2599)





