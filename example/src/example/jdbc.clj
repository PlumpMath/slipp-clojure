(ns example.jdbc
  (:require
    [clojure.java.jdbc :as sql]))

(let [db-host "localhost"
      db-port 3306
      db-name "test"]

    (def db {:classname "com.mysql.jdbc.Driver" ; must be in classpath
           :subprotocol "mysql"
           :subname (str "//" db-host ":" db-port "/" db-name)
           :user "slipp"
           :password "password"}))

(defn create-users-table []
    (sql/with-connection db
      (sql/create-table
        :example
        [:id "varchar(32)"]
        [:pass "varchar(100)"])))

(defn add-user [user]
  (sql/with-connection db
  (sql/insert-record :example user)))

