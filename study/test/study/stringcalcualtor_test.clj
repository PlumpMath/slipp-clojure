(ns study.stringcalculator-test
  (:require [clojure.test :refer :all]
            [study.stringcalculator :refer :all]))


(deftest test-add
  (testing "empty string"
    (is (= 0 (add ""))))
  (testing "two number, separator comma")
    (is (= 3 (add "1,2")))
  (testing "three number, separator comma")
    (is (= 6 (add "1,2,3")))
  (testing "three number, separator comma and new line")
    (is (= 6 (add "1,2\n3")))
  (testing "custom separator")
    (is (= 6 (add "//;\n1;2;3")))
  (testing "custom separator")
    (is (= 6 (add "//:\n1:2:3"))) )

(deftest test-result
  (testing "find custom delimeter, values"
    (is (=  ["//;\n1;2;3" ";" "1;2;3"] (result "//;\n1;2;3"))))
  )

(run-tests)




