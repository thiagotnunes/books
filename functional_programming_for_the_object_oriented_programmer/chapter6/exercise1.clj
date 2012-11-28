(def factorial
  (fn [n]
    (if (zero? n)
      1
      (* n (factorial (- n 1))))))
