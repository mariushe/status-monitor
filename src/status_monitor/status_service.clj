(ns status-monitor.status-service
  (:require [status-monitor.status-remote :as status-remote]))

(def get-status (fn [services-to-check] (map status services-to-check)))

(def status (fn [name] (analyze-status-report (status-remote/get-status-update) name)))

(def analyze-status-report (fn [report name] {:name name :status (-> report :status)})) 
