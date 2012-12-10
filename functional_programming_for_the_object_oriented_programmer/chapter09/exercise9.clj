(def to-int-sequence
  (fn [string]
    (map #(Character/getNumericValue %) string)))

(def divisible-by?
  (fn [n, div]
    (= (rem n div) 0)))

(def check-sum
  (fn [digits]
    (reduce + (map-indexed 
      #(if (odd? %1)
         %2
         (* 3 %2))
      digits))))

; Results are
; 074182265830 - true
; 731124100023 - true
; 722252601404 - false

(def upc?
  (fn [upc]
    (divisible-by? (check-sum (to-int-sequence upc)) 10)))
