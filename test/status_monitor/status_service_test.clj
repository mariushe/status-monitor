(ns status-monitor.status-service-test
  (:use clojure.test)
  (:require [status-monitor.status-service :as status-service]
            [status-monitor.status-remote :as status-remote]
            [midje.sweet :refer :all]
            [conjure.core :refer :all]))

(fact "getStatusFromServices" 
      (stubbing [status-remote/get-status-update {:status "OK" :name "operation" :notification []}]
                (is (= (status-service/get-status '("operation" "offer"))
                       '({:name "operation" :status "OK"} {:name "offer" :status "OK"})))) 
      => true)

