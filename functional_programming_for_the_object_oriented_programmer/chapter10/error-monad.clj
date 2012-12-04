(use 'clojure.contrib.monads)

(def decider
  (fn [value continuation]
    (if (nil? value)
      nil
      (continuation value))))

(def maybe-monad
  (monad [m-result identity
          m-bind decider]))

(with-monad maybe-monad
            (domonad [a nil
                     b (+ 1 a)]
                    b))

(def oops!
  (fn [reason & args]
    (with-meta (merge {:reason reason}
                      (apply hash-map args))
               {:type :error})))

(def oopsie?
  (fn [value]
    (= (type value) :error)))

(def decider
  (fn [value continuation]
    (if (oopsie? value)
      value
      (continuation value))))

(def error-monad
  (monad [m-result identity
          m-bind decider]))

(def factorial
  (fn [n]
    (cond (< n 0)
          (oops! "Factorial can never be less than zero." :number n)
          (< n 2)
          1
          :else
          (* n (factorial (dec n))))))

(def result
  (with-monad error-monad
              (domonad [big-number (factorial -1)
                        even-bigger (* 2 big-number)]
                       (repeat :a even-bigger))))
