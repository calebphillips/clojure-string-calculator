(ns clojure-string-calculator.core
  (:use 
    [clojure.contrib.str-utils]
    [clojure.string]))

(defn to-i [s]
  (try
    (Integer. s)
    (catch NumberFormatException e 0)))

(defn replace-custom [s]
  (if (.startsWith s "//")
    (replace s (str (get s 2)) ",")
    s))

(defn normalize-delims [s]
  (replace (replace-custom s) "\n" ","))

(defn parse-numbers [s]
  (map to-i (split (normalize-delims s) (re-pattern ","))))

(defn add-numbers [s]
  (reduce + (parse-numbers s)))

(defn add [s] 
  (if (empty? s) 0 
    (add-numbers s)))
      
