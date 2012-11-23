;; Gets the first pair from the list
(def first-pair-of (fn [list] (take 2 list)))

;; Removes duplicates
(def remove-duplicates-from (fn [list] (distinct list)))

;; Concatenate all the lists
(def append-all (fn [& lists] (apply concat lists)))

;; Generate x times the number n
(def times (fn [x, n] (repeat x n)))

;; Shuffle (kind of) the collections
(def shuffle-them (fn [& lists] (apply interleave lists)))

;; Remove the nth element
(def remove-element-from (fn [n list] (drop n list)))

;; Remove the last element
(def remove-last-from (fn [list] (drop-last list)))

;; Returns a single 1 level list from deeper ones
(def one-level (fn [list] (flatten list)))

;; Get coordinates
(def coordinates-from (fn [list] (partition 2 list)))

;; Are all even?
(def are-all-even? (fn [list] (every? even? list)))

;; Get all unwanted (do not match pred)
(def all-unwanted (fn [pred list] (remove pred list)))
