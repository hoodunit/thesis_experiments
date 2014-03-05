(ns com.android.helloworld.core
  (:gen-class
   :extends android.app.Activity
   :exposes-methods {onCreate superOnCreate})
  (:import [android.app Activity]
           [android.os Bundle]))

(defn -onCreate [this #^android.os.Bundle bundle ]
  (.superOnCreate this bundle)
  (.setContentView this com.android.helloworld.R$layout/main))
