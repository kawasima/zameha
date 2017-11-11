(ns zameha.core
  (:require [compojure.api.sweet :refer :all]
            [clj-audio.core :refer [->stream play decode stop]]
            [clojure.core.async :refer [thread]]
            [ring.util.http-response :refer :all]
            [ring.adapter.jetty :as jetty]
            [environ.core :refer [env]]))

(defapi alarm
  (POST "/alarm/start" []
    (thread (-> (->stream (env :alarm-file))
                decode
                play))
    (ok {:message "start"}))

  (POST "/alarm/stop" []
    (stop)
    (ok {:message "stop"})))


(defn -main [& args]
  (jetty/run-jetty alarm {:port (Integer/parseInt (or (env :port) "3000"))}))
