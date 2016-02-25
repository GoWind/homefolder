

(defmacro validate
  [m & fields]
  (if (not= 0 (mod (count fields) 3))
    (throw (IllegalArgumentException. "clauses not a set of 3 fields"))
    (let [ partitions (partition 3 fields) ]
      (if (= 0 (count partitions))
        true
        (let [v  (first partitions)
              f (first v)
              a (nth v 1)
              s (nth v 2)]
          `(if (apply ~f  ~(conj a m))
             (validate ~m ~@(mapcat concat (rest partitions)))
             (throw (IllegalArgumentException. ~s))))))))

(def q 2)

(defn g [a b] (> a b))
(defn m [a] (odd? a))
(validate q
          g [5] "number is not greater than 5"
          m [] "number must be odd")
