(require '[clojure.zip :as zip])

(defn at? [zipper element]
  (= (zip/node zipper) element))

(defn below? [zipper element]
  (at? (zip/down zipper) element))

(defn fact? [zipper]
  (at? zipper '=>))

(defn to-do [zipper]
  (cond (zip/end? zipper)
        zipper
        
        (at? zipper 'facts)
        (-> (zip/replace zipper 'do) to-do)

        (fact? zipper)
        (-> zipper 
          zip/left
          zip/remove
          zip/next
          (zip/replace (list 'expect (-> zipper zip/left zip/node) (-> zipper zip/node) (-> zipper zip/right zip/node)))
          zip/right
          zip/remove
          zip/next
          to-do)

        :else
        (to-do (zip/next zipper))
        ))

(defn transform [form]
  (-> form zip/seq-zip to-do zip/root))
