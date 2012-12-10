(require '[clojure.zip :as zip])


(defn tumult [form]
  (letfn [(end? [zipper]
            (zip/end? zipper))
          (branch? [zipper]
            (zip/branch? zipper))
          (at? [zipper, place]
            (= (zip/node zipper) place))
          (below? [zipper, place]
            (and (branch? zipper)
                 (at? (-> zipper zip/down) place)))
          (traverse [zipper]
            (cond (end? zipper)
                  zipper

                  (at? zipper '+)
                  (step (fn [] (zip/replace zipper 'PLUS)))

                  (below? zipper '-)
                  (step (fn [] (zip/replace zipper 555555)))

                  (below? zipper '*)
                  (redo (fn [] (zip/replace zipper '(- 1 2))))

                  (at? zipper '/)
                  (step (fn [] (-> zipper
                                 zip/right
                                 zip/remove
                                 zip/right
                                 zip/remove
                                 (zip/insert-right (-> zipper zip/right zip/node))
                                 (zip/insert-right (-> zipper zip/right zip/right zip/node)))))

                  :else
                  (-> zipper zip/next traverse)))
          (redo [action]
            (-> (action)
              traverse))
          (step [action]
            (-> (action)
              zip/next
              traverse))]
    (-> form zip/seq-zip traverse zip/root)))
