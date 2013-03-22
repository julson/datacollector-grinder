(ns datacollector-grinder.load_test
  (:import [net.grinder.script Grinder Test])
  (:require [datacollector-grinder.core :as core]
            [clj-http.client :as http]))

(def host "localhost")
(def port "8080")

(let [grinder Grinder/grinder
      test (Test. 1 "Load test")]
  (.. test (record http/post))
  (fn []
    (fn []
      (let [url (str "http://" host ":" port "/DataCollector/collector/v1/save")]
        (http/post url {:form-params (core/generate-post-data)
                        :content-type :json})))))