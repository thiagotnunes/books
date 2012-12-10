(require '[clojure.zip :as zip])

(defn next-ends? [zipper]
  (zip/end? (zip/next zipper)))

(defn skip-to-rightmost-leaf [zipper]
  (cond (next-ends? zipper)
        zipper

        :else
        (skip-to-rightmost-leaf (zip/next zipper))))
