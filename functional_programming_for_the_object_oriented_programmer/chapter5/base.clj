;; Exercise 1 - Extract a common apply-message-to to remove duplication from make and send-to
;; Exercise 4 - If the method does not exist, tries to fetch an instance variable
(def apply-message-to (fn [class instance message args]
                        (let [method (or (message (:__instance_methods__ class) message))]
                          (apply method instance args))))

(def make (fn [class & args]
            (let [instance {:__class_symbol__ (:__own_symbol__ class)}]
              (apply-message-to class instance :add-instance-values args))))

(def send-to (fn [instance message & args]
               (let [class (eval (:__class_symbol__ instance))]
                 (apply-message-to class instance message args))))

;; Exercise 2 - class-name method will return the symbol and class will return the class itself
(def Point 
  {
   :__own_symbol__ 'Point
   :__instance_methods__ {
                          :add-instance-values (fn [this x y] (assoc this :x x :y y))
                          :shift (fn [this xinc yinc]
                                   (make Point (+ (:x this) xinc) (+ (:y this) yinc)))
                          :class-name (fn [this] 'Point)
                          :class (fn [this] Point)
                          :origin (fn [this] (make Point 0 0))
                          }
   }
  )
