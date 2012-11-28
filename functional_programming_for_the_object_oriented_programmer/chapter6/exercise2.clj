(def factorial
  (fn [n acc]
    (if (zero? n)
      acc
      (factorial (- n 1) (* n acc)))))
