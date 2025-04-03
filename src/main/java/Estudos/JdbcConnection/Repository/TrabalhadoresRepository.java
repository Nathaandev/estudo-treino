package Estudos.JdbcConnection.Repository;
import Estudos.JdbcConnection.ConnectionJDBC;
import Estudos.JdbcConnection.Dominio.Trabalhadores;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TrabalhadoresRepository {
    public static void save (Trabalhadores trabalhadores){
        String sql = "INSERT INTO `contas`.`trabalhadores` (`Nome`, `idade`) VALUES ('%s', '%d')".formatted(trabalhadores.getNome(), trabalhadores.getIdade());
        try(Connection conn = ConnectionJDBC.getConnection();
            Statement smt = conn.createStatement()){
            int rows = smt.executeUpdate(sql);
            System.out.print(rows);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
