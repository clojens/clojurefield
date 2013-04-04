;; m2
(def avail-players [\A \B \C \D])
(def random (java.util.Random.))

(defn random-trans []
  (nth avail-players (.nextInt random (count avail-players))))

(defn random-amount []
  (float (/ (.nextInt random (count (range 1 10000))) 25 )))

; No parens around function names
(def map-val {:trans random-trans :amt random-amount})

(println ((:trans map-val)))
(println ((:amt map-val)))

(def player {:name :number :something :age})

;(def p1 (atom :player))
;(def p2 (atom :player))

;; m1
;(defmulti player :Player)
;(defmethod player :p1 [] {:name "Rob"})
