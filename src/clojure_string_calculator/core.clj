(ns clojure-string-calculator.core
  (:use [clojure.string :only [join split]]))

(defn to-numbers [s]
  (map #(Integer. %) (filter not-empty (split s #"[^\d|^-]"))))

(defn format-exception [negatives]
  (Exception. (str "Negatives not allowed: " (join ", " negatives))))

(defn add [s] 
  (let [numbers (filter #(< % 1001) (to-numbers s)) negatives (filter neg? numbers)]
    (if (not-empty negatives)
      (throw (format-exception negatives)) 
      (reduce + numbers))))
