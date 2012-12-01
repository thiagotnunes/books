(def check-sum
  (fn [digits]
    (reduce + (map-indexed #(* (inc %1) %2) digits))))
