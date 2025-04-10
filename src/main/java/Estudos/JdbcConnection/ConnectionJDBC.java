package Estudos.JdbcConnection;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
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
    public static JdbcRowSet getJDBCRowSet() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/contas";
        String username = "root";
        String password = "rootd";
       JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
       jdbcRowSet.setUrl(url);
       jdbcRowSet.setUsername(username);
       jdbcRowSet.setPassword(password);

        return jdbcRowSet;
    }

    public static CachedRowSet getCachedRowSet() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/contas";
        String username = "root";
        String password = "rootd";
        CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        cachedRowSet.setUrl(url);
        cachedRowSet.setUsername(username);
        cachedRowSet.setPassword(password);

        return cachedRowSet;
    }
}
