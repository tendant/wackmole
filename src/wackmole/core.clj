(ns wackmole.core)



(defn pick []
  (nth ["X" "O"] (rand-int 2)))

(defn pickgrid []
  (assoc (vec (repeat 9 "O")) (rand-int 9) "X"))

(defn foo
  "I don't do a whole lot."
  []
  (let [expected (pickgrid)]
    (doall (map println (partition 3 expected)))
    (println "Where to wack?")
    (let [input (read-line)
          aa (dec (Integer/valueOf input))
          ]
      (= "X" (nth expected aa))
      ))
  )
