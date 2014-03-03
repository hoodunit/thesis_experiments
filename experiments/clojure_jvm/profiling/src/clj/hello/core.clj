(ns hello.core
  (:gen-class 
   :methods [[greet [] void]]))

(defn -greet [this]
  (println "Hello world"))
