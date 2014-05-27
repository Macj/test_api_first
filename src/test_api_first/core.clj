(ns test-api-first.core
  (:use [ring.adapter.jetty]
        [ring.util.response]
        [compojure.core])
  (:require [org.httpkit.client :as http]
            [test_api_first.query-generator :as gen]))

(defn send-it [url data]
  (http/get url {:json data}))

(defn make-request []
  (let [data (gen/query-generator)
        urls (conf/urls)]
    (doseq [url urls] (send-it url data)
      (println url))))

(def number-of-threads
  5)

; need to fix
; doesn't work at server, only in REPL
(defn app []
  (time (doall (map deref (doall (for [i (range number-of-threads)] (future (make-request))))))))

(defn -main []
  (run-jetty app {:port 8080}))