(require '[clojure.zip :as zip])

(defn all-vectors [tree]
  (letfn [(extract-vectors [vectors, node]
          (let [node-element (zip/node node)
                next-node (zip/next node)]
            (cond (zip/end? node)
                  vectors

                  (vector? node-element)
                  (extract-vectors (cons node-element vectors) next-node)

                  :else
                  (extract-vectors vectors next-node)
                  )))]
  (reverse (extract-vectors '() (zip/seq-zip tree)))))

(defn first-vector [tree]
  (letfn [(find-first [node]
            (cond (zip/end? node)
                  nil

                  (vector? (zip/node node))
                  (zip/node node)

                  :else
                  (find-first (zip/next node))))]
    (find-first (zip/seq-zip tree))))
