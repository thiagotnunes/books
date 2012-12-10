(defn mmap [f coll]
  (new clojure.lang.LazySeq
       (fn []
         (if (empty? coll)
         nil
         (cons (f (first coll)) (mmap f (rest coll)))))))
