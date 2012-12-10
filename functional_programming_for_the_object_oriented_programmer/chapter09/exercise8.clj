(def check-sum
  (fn [digits]
    (reduce + (map-indexed #(* (inc %1) %2) digits))))

(def to-int-sequence
  (fn [string]
    (map #(Character/getNumericValue %) string)))

; Results are
; 0131774115 - true
; 0977716614 - false
; 1934356190 - true

(def divisible-by?
  (fn [n, div]
    (= (rem n div) 0)))

(def isbn?
  (fn [isbn]
    (divisible-by? (check-sum (to-int-sequence isbn)) 11)))
