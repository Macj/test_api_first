(ns test-api-first.config)

(defn urls []
  (let [base "http://"
    clojure (str base "localhost:3000")
    apple (str base "localhost:3000")
    google (str base "localhost:3000")
    wiki (str base "localhost:3000")
    nat-geo (str base "localhost:3000")]
  (vector clojure apple google wiki nat-geo)))

(def r_count 500)
(def t_count 5)