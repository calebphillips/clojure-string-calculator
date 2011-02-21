(ns clojure-string-calculator.core
  (:use 
    [clojure.string]))


(defn add [s] 
  (if (empty? s) 
    0
    (reduce + (map #(Integer. %) (split s #"[^\d]")))))
      
