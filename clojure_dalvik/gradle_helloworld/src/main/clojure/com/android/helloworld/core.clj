(ns com.android.helloworld.core
  (:gen-class
   :extends android.app.Activity
   :exposes-methods {onCreate superOnCreate})
  (:import [android.app Activity]
           [android.os Bundle]
           [android.util Log]
           [android.os Debug]))

(defn -onCreate [this #^android.os.Bundle bundle ]
  (.superOnCreate this bundle)
  (.setContentView this com.android.helloworld.R$layout/main)
  (Log/v "com.android.helloworld.core" "Clojure!"))
