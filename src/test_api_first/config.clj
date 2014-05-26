(ns test-api-first.config)

(defn urls []
  (let [base "http://"
    clojure (str base "clojure.org")
    apple (str base "apple.com")
    google (str base "google.com")
    wiki (str base "wikipedia.org")
    nat-geo (str base "nationalgeographic.org")]
  [clojure apple google wiki nat-geo]))

(def number-of-threads
  5)