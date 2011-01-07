(ns clojure-string-calculator.core-spec
  (:use
    [speclj.core]
    [clojure-string-calculator.core]
    [clojure.contrib.str-utils]))

(describe "String Calculator"

          (it "returns 0 for the empty string"
              (should= 0 (add "")))

          (it "returns 5 for 5"
              (should= 5  (add "5")))

          (it "returns 27 for 27"
              (should= 27 (add "27")))
          
          (it "returns 3 for 1,2"
              (should= 3 (add "1,2")))
          
          (it "returns 19 for 15,4"
              (should= 19 (add "15,4")))
          
          (it "returns 6 for 1,2,3"
              (should= 6 (add "1,2,3")))
          
          (it "returns 2000 for 100 20s"
              (should= 2000 (add (str-join "," (repeat 100 "20")))))

          (it "allows the newline as a delimiter"
              (should= 6 (add "1\n2\n3"))
              (should= 60 (add "10\n20\n30")))

          (it "allows the newline and comma to be mixed"
              (should= 6 (add "1\n2,3")))

          (it "allows customer delimiters"
              (should= 6 (add "//;\n1;2;3"))
              (should= 13 (add "//$\n3$4$6")))
          )

(run-specs)
