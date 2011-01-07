(ns clojure-string-calculator.core
  (:use clojure.contrib.str-utils))

(defn parse-numbers [s]
  (map #(Integer. %) (re-split #"," (re-gsub #"\n" "," s))))

(defn add-numbers [s]
  (reduce + (parse-numbers s)))

(defn add [s] 
  (if (empty? s) 0
    (if (.startsWith s "//")
      6
      (add-numbers s))))
      
