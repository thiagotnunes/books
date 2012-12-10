(defn ffilter [f coll]
  (new clojure.lang.LazySeq
       (fn []
         (cond (empty? coll)
               nil

               (-> coll first f)
               (cons (first coll) (ffilter f (rest coll)))

               :else
               (ffilter f (rest coll))))))
