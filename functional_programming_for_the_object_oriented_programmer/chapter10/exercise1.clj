(-> (concat '(a b c) '(d e f))
  ((fn [step1]
     (-> (count step1)
       ((fn [step2]
          (odd? step2)))))))
