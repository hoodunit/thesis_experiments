(ns org.helloandroid.core.main
  (:use [neko.activity :only [defactivity set-content-view!]]
        [neko.threading :only [on-ui]]
        [neko.ui :only [make-ui]]))

(defactivity org.helloandroid.core.MyActivity
  ;; :def a
  :on-create
  (fn [this bundle]
    (on-ui
     (set-content-view! this
      (make-ui [:linear-layout {}
                [:text-view {:text "Hello from Clojure!"}]])))))
