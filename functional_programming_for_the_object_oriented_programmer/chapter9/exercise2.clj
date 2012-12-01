(def separate
  (fn [pred sequence]
    ((juxt (partial filter pred) (partial remove pred)) sequence)))
