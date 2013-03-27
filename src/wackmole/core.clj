(ns wackmole.core)



(defn pick []
  (nth ["X" "O"] (rand-int 2)))

(defn pickgrid []
  (assoc (vec (repeat 9 "O")) (rand-int 9) "X"))

(defn int-val [x]
  (mod (dec (Integer/valueOf x)) 3))

(defn foo
  "I don't do a whole lot."
  []
  (let [expected (pickgrid)]
    (doall (map println (partition 3 expected)))
    (println "Where to wack?")
    (let [_ (println "Pick X:")
          x (int-val (read-line))
          _ (println "Pick Y:")
          y (int-val (read-line))
          z (+ (* 3 y) x)
          ]
      (= "X" (nth expected z))
      ))
  )
