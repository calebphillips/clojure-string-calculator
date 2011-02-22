(ns clojure-string-calculator.core
  (:use [clojure.string :only [split]]))

(defn to-numbers [s]
      (map #(Integer. %) (filter #(not (empty? %)) (split s #"[^\d|^-]"))))

(defn add [s] 
      (let [numbers (to-numbers s)
            negatives (filter neg? numbers)]
        (if (not-empty negatives)
          (throw (Exception. (apply str "Negatives not allowed: " (interpose ", " negatives))))
          (reduce + numbers))))
      
