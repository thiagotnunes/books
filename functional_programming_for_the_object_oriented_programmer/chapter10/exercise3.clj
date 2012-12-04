(-> 3
  ((fn [step1]
     (-> (+ step1 2)
       ((fn [step2]
          (inc step2)))))))
