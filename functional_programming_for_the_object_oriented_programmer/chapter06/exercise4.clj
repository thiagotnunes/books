(def mymultiply
  (fn [list acc]
    (if (empty? list)
      acc
      (mymultiply (rest list) (* (first list) acc)))))

(def accumulate
  (fn [combiner list acc]
    (if (empty? list)
      acc
      (accumulate combiner (rest list) (combiner (first list) acc)))))
