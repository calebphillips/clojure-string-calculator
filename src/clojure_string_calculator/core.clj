(ns clojure-string-calculator.core
  (:use [clojure.string :only [split join]]))

(defn to-numbers [s]
      (map #(Integer. %) (filter not-empty (split s #"[^\d|^-]"))))

(defn format-exception [coll]
      (Exception. (str "Negatives not allowed: " (join ", " coll))))

(defn add [s] 
      (let [numbers (to-numbers s)
            negatives (filter neg? numbers)]
        (if (not-empty negatives)
          (throw (format-exception negatives))
          (reduce + numbers))))
      
