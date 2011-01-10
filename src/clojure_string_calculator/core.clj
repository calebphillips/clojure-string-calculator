(ns clojure-string-calculator.core
  (:use 
    [clojure.contrib.str-utils]
    [clojure.string]))

(defn to-i [s]
  (try
    (Integer. s)
    (catch NumberFormatException e 0)))

(defn delim [s]
  (if (.startsWith s "//")
    (str (get s 2)) 
    ","))

(defn parse-numbers [s]
  (map to-i (split (replace s "\n" (delim s)) (re-pattern (delim s)))))

(defn add-numbers [s]
  (reduce + (parse-numbers s)))

(defn add [s] 
  (if (empty? s) 0 
    (add-numbers s)))
      
