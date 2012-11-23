(def tails (fn [list] 
             (if (empty? list) 
               [list]
               (concat [list] (tails (drop 1 list))) )
             ))
