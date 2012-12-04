(-> '(a b c)
  ((fn [step1]
    (-> (concat step1 '(d e f))
      ((fn [step2]
         (-> (count step2)
           ((fn [step3]
              (odd? step3))))))))))

