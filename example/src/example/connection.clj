(ns example.jdbc)

(let [db-host "localhost"
      db-port 3306
      db-name "test"]

    (def db {:classname "com.mysql.jdbc.Driver" ; must be in classpath
           :subprotocol "mysql"
           :subname (str "//" db-host ":" db-port "/" db-name)
           :user "slipp"
           :password "password"}))
