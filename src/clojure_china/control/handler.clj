(ns clojure-china.control.handler
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [noir.session :as session]
            [compojure.core :refer :all]
            [clojure-china.pages.index :refer [index register]]))

(defroutes app-routes
           (GET "/" [] (index nil))
           (POST "/register" {params :params} (register params))
           (route/resources "/")
           (route/not-found "Not Found"))

(def app
  (->
    (handler/site app-routes)
    (session/wrap-noir-session)))
