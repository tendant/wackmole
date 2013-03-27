(ns wackmole.core)

(def score (atom 0))

(defn pick []
  (nth ["X" "O"] (rand-int 2)))

(defn pickgrid []
  (assoc (vec (repeat 9 "O")) (rand-int 9) "X"))

(defn int-val [x]
  (mod (dec (Integer/valueOf x)) 3))

(defn play
  "I don't do a whole lot."
  []
  (let [expected (pickgrid)]
    (doall (map println (partition 3 expected)))
    (println "Where to wack?")
    (let [_ (println "Pick X:")
          x (int-val (read-line))
          _ (println (inc x))
          _ (println "Pick Y:")
          y (int-val (read-line))
          _ (println (inc y))
          z (+ (* 3 y) x)
          ]
      (= "X" (nth expected z))
      ))
  )

(defn score-result [result]
  (if result
    (swap! score inc)
    (swap! score dec)
    )
  (println "Your current score is: " @score)
  (println)
  )

(defn message [result]
  (if result
    "You hit the mole!"
    "Just missed"))
    
  
(defn check-result [result]
  (do
    (println)
    (println (message result))
    (score-result result)
    ))

(defn multi-play []
   (try
     (check-result
      (play))
     (multi-play)
     (catch java.lang.NumberFormatException e
       (println "Exiting nicely...")
       )
     ))
