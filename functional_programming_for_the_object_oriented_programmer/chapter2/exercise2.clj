(def third (fn [list] (nth list 2)))

(def third2 (fn [list] (first (rest (rest list)))))
