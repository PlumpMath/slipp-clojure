(ns example.jdbc
  (:require
    [clojure.java.jdbc :as sql]))

(def db
  {:subprotocol "h2"
    :subname "jdbc:h2:tcp://localhost/~/example"
    :user "sa"
    :password ""})

(defn create-users-table []
    (sql/with-connection db
      (sql/create-table
        :example
        [:id "varchar(32) PRIMARY KEY"]
        [:pass "varchar(100)"])))


(defn add-user [user]
  (sql/with-connection db
  (sql/insert-record :users user)))

(create-users-table)
(add-user {:id "foo" :pass "bar"})
