(ns test_api_first.core
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
    (doseq [url urls] (send-it url data))))

(defn make-requests []
  (let [number_of_requests conf/r_count]
    ;(println number_of_requests)
    (dotimes [n number_of_requests] 
      (make-request)
      ;(println n)
      )
  ))

; (defn start-thread [fn]
;   (.start (Thread. fn)))

(defn main []
  ; (dotimes [n number-of-threads]
    ; (future (start-thread #(number-of-requests 10)))))
  (let [fn_list [#(make-requests)]]
    (def mm (vector))
    (dotimes [n conf/t_count] 
      (def mm (concat mm fn_list)))
    (println "Hi there")
    (println (time
      (apply pcalls mm)))))


(defn app []
  (main))
; need to fix
; doesn't work at server, only in REPL
; (defn app []
;   (time (doall (map deref (doall (for [i (range number-of-threads)] (future (make-request))))))))

(defn -main []
  (run-jetty app {:port 8080}))
