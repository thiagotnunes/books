(def make (fn [type & args] (apply type args)))
(def send-to (fn [object message & args]
               (apply (message (:__methods__ object)) object args)))
(def Point
  (fn [x y]
    {
     :x x
     :y y
     :__class_symbol__ 'Point
     :__methods__ {
                   :class :__class_symbol__
                   :getX :x
                   :getY :y
                   :shift (fn [this xinc yinc]
                            (make Point (+ (send-to this :getX) xinc)
                                  (+ (send-to this :getY) yinc)))
                   :add (fn [this point]
                          (send-to this :shift (send-to point :getX) (send-to point :getY)))
                   }
     }
    )
  )
