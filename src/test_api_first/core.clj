(ns test-api-first.core
  (:use [ring.adapter.jetty]
        [ring.util.response]
        [compojure.core])
  (:require [org.httpkit.client :as http]
            [test_api_first.query-generator :as gen]
            [test-api-first.config :as conf]))

(defn send-it [url data]
  (http/get (str url) {:json data}))

(defn make-request []
  (let [data (gen/query-generator)
        urls (conf/urls)]
    (doseq [url urls] (send-it url data)
      (println url))))

(defn number-of-requests [number]
  (dotimes [n number] (make-request)))

(def number-of-threads
  5)

(defn start-thread [fn]
  (.start (Thread. fn)))

(defn main-method []
  (dotimes [n number-of-threads]
    (future (start-thread #(number-of-requests 10)))))

; need to fix
; doesn't work at server, only in REPL
; (defn app []
;   (time (doall (map deref (doall (for [i (range number-of-threads)] (future (make-request))))))))

; (defn -main []
;   (run-jetty app {:port 8080}))
