(ns clojure-string-calculator.core-spec
  (:use
    [speclj.core]
    [clojure-string-calculator.core]
    [clojure.string :only [join]]))

(describe "String Calculator"
          (it "returns 0 for the empty string"
              (should= 0 (add "")))
          
          (it "returns the number when the string is a single number"
              (should= 5 (add "5"))
              (should= 27 (add "27")))
          
          (it "returns the sum when the stirng contains 2 numbers"
              (should= 3 (add "1,2")))
          
          (it "returns the sum when string contains lots of numbers"
              (should= 2000 (add (join "," (repeat 100 20)))))
          
          (it "allows the newline as a delimiter"
              (should= 6 (add "1\n2\n3"))
              (should= 8 (add "1\n4,3")))
          
          (it "allows custom delimiters"
              (should= 11 (add "//;\n4;5;2"))
              (should= 46 (add "//x\n20x10x16")))
          
          (it "does not allow negatives"
              (should-throw (add "-1,5")))
          
          (it "includes the negatives in the error message"
              (should-throw Exception "Negatives not allowed: -4, -13" (add "-4,87,-13"))))

          

(run-specs)
