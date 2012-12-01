(def my-atom (atom 0))
(swap! my-atom (partial + 33))
(deref my-atom)

(def my-atom (atom 0))
(swap! my-atom #(+ % 33))
(deref my-atom)

(def my-atom (atom 0))
(swap! my-atom (fn [x] 33))
(deref my-atom)
