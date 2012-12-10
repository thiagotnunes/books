(def myfun
  (let [x 3]
    (fn [] x)))


; Predicting the results of
; x -> undefined
; (myfun) -> 3
