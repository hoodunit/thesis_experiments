(ns hello.core
  (:gen-class
   :methods [#^{:static true} [greet [] void]]))

(defn -greet []
  (println "Hello world"))
