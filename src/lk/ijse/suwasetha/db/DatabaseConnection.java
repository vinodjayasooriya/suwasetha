package lk.ijse.suwasetha.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // 1st rule
    private static DatabaseConnection dbconnection;
    //-----------------------------
    private Connection connection;
    //-----------------------------

    // 2nd rule
    private DatabaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/suwasetha",
                "root"
                , "");
    }
    // 3rd rule
    public static DatabaseConnection getInstance() throws SQLException, ClassNotFoundException {
       /* if (null==dbconnection){
            dbconnection= new DatabaseConnection();
        }
        return dbconnection;*/
       return (null==dbconnection)?
               (dbconnection= new DatabaseConnection()):
               dbconnection;
    }

    public Connection getConnection() {
        return connection;
    }
}

