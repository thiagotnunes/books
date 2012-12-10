(require '[clojure.zip :as zip])


(defn tumult [form]
  (letfn [(end? [zipper]
            (zip/end? zipper))
          (branch? [zipper]
            (zip/branch? zipper))
          (at? [zipper, place]
            (= (zip/node zipper) place))
          (traverse [zipper]
            (cond (end? zipper)
                  zipper

                  (at? zipper '+)
                  (step (fn [] (zip/replace zipper 'PLUS)))

                  (and (branch? zipper)
                       (at? (-> zipper zip/down) '-))
                  (step (fn [] (zip/append-child zipper 555555)))

                  (and (branch? zipper)
                       (at? (-> zipper zip/down) '*))
                  (step (fn [] (zip/replace zipper '(/ 1 (+ 3 (- 0 9999))))))

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
          (step [action]
            (-> (action)
              zip/next
              traverse))]
    (-> form zip/seq-zip traverse zip/root)))
