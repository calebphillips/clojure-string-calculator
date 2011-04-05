(ns clojure-string-calculator.test.core
  (:use [clojure-string-calculator.core] :reload)
  (:use [clojure.test]
        [clojure.string :only [join]]))

(deftest string-calculator 
  (is (= 0 (add "")))
  
  (testing "strings with a single number"
           (is (= 5 (add "5")))
           (is (= 27 (add "27"))))

  (testing "strings with two numbers"
           (is (= 3 (add "1,2")))
           (is (= 8 (add "3,5"))))

  (testing "string with lots of numbers"
           (is (= 2000 (add (join "," (repeat 100 20))))))

  (testing "the newline as a delimiter"
           (is (= 6 (add "1\n2\n3")))
           (is (= 9 (add "3,4\n2"))))

  (testing "custom delimiters"
           (is (= 15 (add "//;\n9;4;2")))
           (is (= 13 (add "//x\n2x3x4x4"))))

  (testing "negative numbers"
           (is (thrown? Exception (add "-1,4,-5")))
           (is (thrown? Exception "Negatives not allowed: -4, -65" (add "-4,5,-65"))))
  )
