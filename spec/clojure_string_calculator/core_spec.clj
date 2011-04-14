(ns clojure-string-calculator.core-spec
  (:use [speclj.core]
        [clojure-string-calculator.core]
        [clojure.string :only [join]]))

(describe "String Calculator"
          (it "returns 0 for the empty string"
              (should= 0 (add "")))

          (it "returns the number when the string consists of a single number"
              (should= 5 (add "5"))
              (should= 27 (add "27")))

          (it "returns the sum when the string contains two numbers"
              (should= 3 (add "1,2"))
              (should= 8 (add "3,5")))

          (it "returns the sum when the string contains lots of numbers"
              (should= 2000 (add (join "," (repeat 100 20)))))

          (it "allows the newline as a delimiter"
              (should= 6 (add "1\n2\n3"))
              (should= 9 (add "3,4\n2")))

          (it "allows custom delimiters"
              (should= 15 (add "//;\n9;4;2"))
              (should= 13 (add "//x\n2x3x4x4")))

          (it "does not allow negative numbers"
              (should-throw (add "-1,4,-5")))

          (it "includes the negatives in the error message"
              (should-throw Exception "Negatives not allowed: -4, -65" (add "-4,5,-65")))

          (it "ignores numbers bigger than 1000"
              (should= 2 (add "2,1001"))
              (should= 20 (add "2000,15,6000000,5,4321")))

          (it "allows custom delimiters of any length"
              (should= 6 (add "//[***]\n1***2***3")))

          (it "allows multiple custom delimiters"
              (should= 6 (add "//[*][%]\n1*2%3"))
              (should= 6 (add "//[***][%%%]\n1***2%%%3")))

          )
