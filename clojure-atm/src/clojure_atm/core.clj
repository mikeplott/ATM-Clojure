(ns clojure-atm.core
  (:require [clojure.string :as str])
  (:gen-class))

(def users (atom {}))

(defn login []
  (println "Press 1 to login or 2 to create an account")
  (println)
  (let [selection (read-line)]
    selection
    (println "you typed" selection)
 ;;   (cond
 ;;      (= 1 selection) 
 ;;      (= 2 selection)
 ;;    (println "Invalid entry please try again")
 ;;    (login)
    (if (= 1 selection)
      (do(println)
        (println "Enter your username")
        (let [username (read-line)]
          username
          (not (get-in (users username))
            (println "User does not exist, please try again" login))
          (let [user (get-in (users username))]
            (println "Enter your password")
            (let [password (read-line)]
              password
              (not (get-in (user password))
                (println "Invalid password, please try again" login))
              (let [user {:username username :password password}]
                user))))))
    (if (= 2 selection)
      (do (println "New user registration")
       (println "Please enter a username")
       (let [username (read-line)]
         username
         (println "Please enter a password")
         (let [password (read-line)]
           password
           (assoc-in users username {:username username :password password})
           (let [user {:username username :password password}]
             user)))))))
  
  


    

          
          

            
      


(defn -main []
  (println "Welcome!")
  (login))
  
