package Estudos.crud.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/contas";
        String ursename = "root";
        String password = "rootd";
        return DriverManager.getConnection(url, ursename, password);
    }
}
