(ns clojure-string-calculator.core-spec
  (:use
    [speclj.core]
    [clojure-string-calculator.core]))

(describe "String Calculator"

          (it "returns 0 for the empty string"
              (should= 0 (add ""))))
(run-specs)
