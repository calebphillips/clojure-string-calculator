(ns clojure-string-calculator.core
  (:use clojure.contrib.str-utils))

(defn add [s] 
  (if (empty? s) 0
    (if (.contains s ",") 
      (reduce + (map #(Integer. %) (re-split #"," s)))
      (Integer. s))))
