package Estudos.JdbcConnection.Repository;
import Estudos.JdbcConnection.ConnectionJDBC;
import Estudos.JdbcConnection.Dominio.Trabalhadores;
import Estudos.JdbcConnection.listener.CustomRowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class TrabalhadoresRepositoryRowSet {


    public static List<Trabalhadores> FindByNameJdbcRowSet(String Nome){
        String sql = "SELECT * FROM trabalhadores WHERE Nome like ?;";
        List<Trabalhadores> trabalhadorlist = new ArrayList<>();
        try(JdbcRowSet jrs = ConnectionJDBC.getJDBCRowSet()){
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setString(1, String.format("%%%s%%", Nome));
            jrs.execute();
            while (jrs.next()){
                Trabalhadores trabalhadores = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().id(jrs.getInt("id")).nome(jrs.getString("Nome")).idade(jrs.getInt("idade")).build();
                trabalhadorlist.add(trabalhadores);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trabalhadorlist;
    }
    public static void update(Trabalhadores trabalhadores)  {
        String sql = "SELECT * FROM contas.trabalhadores WHERE (`id` = ?)";
        try (JdbcRowSet jrs = ConnectionJDBC.getJDBCRowSet()){
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, trabalhadores.getId());
            jrs.execute();
            if (!jrs.next()) return;
            jrs.updateString("Nome", trabalhadores.getNome());
            jrs.updateRow();


        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void CachedRowSetupdate(Trabalhadores trabalhadores)  {
        String sql = "SELECT * FROM trabalhadores WHERE (`id` = ?)";
        try (CachedRowSet crs = ConnectionJDBC.getCachedRowSet();
            Connection connection = ConnectionJDBC.getConnection()){
            connection.setAutoCommit(false);
            crs.setCommand(sql);
            crs.setInt(1, trabalhadores.getId());
            crs.execute(connection);
            if (!crs.next()) return;
            crs.updateString("Nome", trabalhadores.getNome());
            crs.updateRow();
            crs.acceptChanges();


        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

