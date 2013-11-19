(ns study.core-test
  (:require [clojure.test :refer :all]
            [study.core :refer :all]))

(deftest test-calculator
  (is (= 4 (add 1 3)))
  (is (= 3 (subtract 4 1)))
  (is (= 12 (multiply 4 3)))
  (is (= 3 (divide 12 4))))

(run-tests)
