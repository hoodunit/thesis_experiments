(ns org.helloandroid.core.main
  (:gen-class
   :extends android.app.Activity
   :exposes-methods {onCreate superOnCreate})
  (:import [android.app Activity]
           [android.os Bundle]
           [android.util Log]
           [android.os Debug]))

(defn -onCreate [this #^android.os.Bundle bundle ]
  (.superOnCreate this bundle)
  (.setContentView this org.helloandroid.core.R$layout/main)
  (.setText (.findViewById this org.helloandroid.core.R$id/helloText) 
            "Hello world")
  (Log/v "helloandroid" "Clojure Android Hello World done")
  (Debug/stopMethodTracing))

