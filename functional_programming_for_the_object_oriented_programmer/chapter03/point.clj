(def Point (fn [x y] {:x x :y y :__class_symbol__ Point}))
(def x :x)
(def y :y)
(def shift (fn [this xinc yinc] (Point (+ xinc (x this)) (+ yinc (y this)))))

;; Exercise 1 - Function that adds two points
(def add (fn [point1 point2] (Point (+ (x point1) (x point2)) (+ (y point1) (y point2)))))
(def add2 (fn [point1 point2] (shift point1 (x point2) (y point2)))) 

;; Exercise 2 - Function that makes a point
(def make (fn [type & args] (apply type args))) 
(def Triangle (fn [point1 point2 point3] {:point1 point1 :point2 point2 :point3 point3 :__class_symbol__ Triangle}))

;; Exercise 3/4 - Check if triangles are the equal in content
(def right-triangle (Triangle (Point 0 0)
                              (Point 0 1)
                              (Point 1 0)))
(def equal-right-triangle (Triangle (Point 0 0)
                                    (Point 0 1)
                                    (Point 1 0)))
(def different-triangle (Triangle (Point 0 0)
                                  (Point 0 10)
                                  (Point 10 0)))
(def equal-triangles? =)

;; Exercise 5 - Function that check if triangle is valid (does not have duplicated points)
(def valid-triangle? (fn [point1 point2 point3] (= (count (distinct [point1 point2 point3])) 3)))

