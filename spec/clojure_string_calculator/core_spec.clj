(ns clojure-string-calculator.core-spec
  (:use
    [speclj.core]
    [clojure-string-calculator.core]
    [clojure.string :only [join]]))

(describe "String Calculator"
          (it "returns 0 for the empty string"
              (should= 0 (add "")))
          
          (it "returns the numbers when the string contains a single number"
               (should= 5 (add "5"))
               (should= 27 (add "27")))

          (it "returns the sum when there are two numbers"
              (should= 3 (add "1,2"))
              (should= 38 (add "20,18")))

          (it "returns the sum when there are more than two numbers"
              (should= 6 (add "1,2,3"))
              (should= 2000 (add (join "," (repeat 100 20)))))

          (it "allows newlines as separators"
              (should= 10 (add "1\n2\n3\n4")))

          (it "allows custom delimiters"
              (should= 9 (add "//;\n2;3;4"))
              (should= 13 (add "//a\n9a4")))

          (it "does not allow negative numbers"
              (should-throw (add "-1,15")))
          
          (it "includes the negatives in the error message"
              (should-throw Exception "Negatives not allowed: -1, -46" (add "-1,14,-46"))))


          

(run-specs)
