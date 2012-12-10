(def accumulate
  (fn [combiner list acc]
    (if (empty? list)
      acc
      (accumulate combiner (rest list) (combiner (first list) acc)))))

(def sillymap
  (fn [element map]
    (assoc map element (count map))))

(accumulate sillymap [:a :b :c] {})
