(ns letter-grid.main
  (:require [clojure.string :as str]))

;; The probability of the character for that column appearing, in each row
(def row-probabilities
  (let [ramp [0.1 0.2 0.3 0.4 0.5]]
    (concat ramp [1.0] (reverse ramp))))

(defn row
  [input probability]
  (for [character input]
    (if (< (rand) probability)
      character
      \space)))

(defn grid
  [input]
  (for [probability row-probabilities]
    (row input probability)))

(defn display
  [grid]
  (println (str/join "\n" (map #(str/join "" %) grid))))

(comment
  (display (grid "dave yarwood")))
