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
    (doseq [url urls] (send-it url data))))
