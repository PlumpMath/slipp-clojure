(ns example.jdbc
  (:require
    [clojure.java.jdbc :as sql]))

(defn create-users-table []
    (sql/with-connection db
      (sql/create-table
        :example
        [:id "varchar(32)"]
        [:pass "varchar(100)"])))


(defn add-user [user]
  (sql/with-connection db
  (sql/insert-record :example user)))

(add-user {:id "foo" :pass "bar"})
