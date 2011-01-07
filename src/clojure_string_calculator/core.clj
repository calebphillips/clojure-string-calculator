(ns clojure-string-calculator.core
  (:use clojure.contrib.str-utils))

(defn parse-numbers [s]
  (map #(Integer. %) (re-split #"," (re-gsub #"\n" "," s))))

(defn add-numbers [s]
  (reduce + (parse-numbers s)))

(defn add [s] 
  (if (empty? s) 0
    (if-let [[ _ delim the-numbers] (re-matches #"//(.*)\n(.*)" s)]
      (add-numbers (re-gsub (re-pattern (java.util.regex.Pattern/quote delim)) "," the-numbers))
      (add-numbers s))))
      
