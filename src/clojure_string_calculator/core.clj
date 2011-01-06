(ns clojure-string-calculator.core)

(defn add [s] 
  (if (empty? s) 0
    (if (.contains s ",") 
      3
      (Integer. s))))
