(ns clojure-string-calculator.core
  (:use clojure.contrib.str-utils))

(defn add-numbers [s]
  (reduce + (map #(Integer. %) (re-split #"," s))))

(defn add [s] 
  (if (empty? s) 0
    (if (.contains s "\n")
      (add-numbers (re-gsub #"\n" "," s))
      (add-numbers s))))
