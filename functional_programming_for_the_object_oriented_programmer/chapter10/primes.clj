(use 'clojure.contrib.monads)

(def multiples
  (fn [n]
    (range (* n 2) 101 n)))

(def non-primes
    #(flatten (with-monad sequence-m
               (domonad [n (range 2 11)]
                        (multiples n)))))

(def unique-nonprimes 
  #(-> (all-nonprimes) set sort))

(def primes
  #(remove (set (all-unique-nonprimes)) (range 2 101)))
