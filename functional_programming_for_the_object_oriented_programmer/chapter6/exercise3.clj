(def myadd
  (fn [list acc]
    (if (empty? list)
      acc
      (myadd (rest list) (+ (first list) acc)))))
