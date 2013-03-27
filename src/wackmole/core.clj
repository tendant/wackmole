(ns wackmole.core)

(defn pick []
  (nth ["X" "O"] (rand-int 2)))


(defn foo
  "I don't do a whole lot."
  []
  (let [expected [(pick) (pick) (pick)]]
    (println expected)
    (let [input (read-line)
          aa (dec (Integer/valueOf input))
          ]
      (= "X" (nth expected aa))
      ))
  )
