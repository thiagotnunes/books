(def to-int-sequence
  (fn [string]
    (map #(Character/getNumericValue %) string)))

(def divisible-by?
  (fn [n, div]
    (= (rem n div) 0)))

; Results are
; 0131774115 - true
; 0977716614 - false
; 1934356190 - true
; 074182265830 - true
; 731124100023 - true
; 722252601404 - false

(def number-checker
  (fn [mapper, divisor]
    (fn [digits]
      (divisible-by? (reduce + (map-indexed mapper (to-int-sequence digits))) divisor))))

(def isbn?
  (fn [isbn]
    ((number-checker #(* (inc %1) %2) 11) isbn)))

(def upc?
  (fn [upc]
    ((number-checker #(if (odd? %1) %2 (* 3 %2)) 10) upc)))
