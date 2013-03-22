(ns datacollector-grinder.core
  (:import [java.util UUID Random]
           [org.apache.commons.lang3 RandomStringUtils]))

(defn random-string [start end]
  (let [len (+ start (.nextInt (Random.) 
                               (- end start)))]
    (RandomStringUtils/randomAlphanumeric len)))

(defn generate-properties [count]
  (zipmap (repeatedly count #(str "prop" (rand-int 20)))
          (repeatedly count #(random-string 512 1024))))

(defn generate-event []
  {:name (random-string 32 256)
   :type (random-string 32 256)
   :timestamp (System/currentTimeMillis)
   :messageId (UUID/randomUUID)
   :flowName (random-string 32 256)
   :domain (random-string 32 256)
   :properties (generate-properties (rand-int 10))})

(defn generate-post-data []
  {:events (vec (repeatedly (+ (rand-int 300) 100)
                            generate-event))})
