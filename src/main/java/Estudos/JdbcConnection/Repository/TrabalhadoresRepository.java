package Estudos.JdbcConnection.Repository;
import Estudos.JdbcConnection.ConnectionJDBC;
import Estudos.JdbcConnection.Dominio.Trabalhadores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrabalhadoresRepository {
    public static void save(Trabalhadores trabalhadores) {
        String sql = "INSERT INTO `contas`.`trabalhadores` (`Nome`, `idade`) VALUES ('%s', '%d')".formatted(trabalhadores.getNome(), trabalhadores.getIdade());
        try (Connection conn = ConnectionJDBC.getConnection();
             Statement smt = conn.createStatement()) {
            int rows = smt.executeUpdate(sql);
            System.out.print(rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM `contas`.`trabalhadores` WHERE (`id` = '%d')".formatted(id);
        try (Connection conn = ConnectionJDBC.getConnection();
             Statement smt = conn.createStatement()) {
            int rows = smt.executeUpdate(sql);
            System.out.print(rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update(Trabalhadores trabalhadores){
        String sql = "UPDATE `contas`.`trabalhadores` SET `Nome` = '%s', `idade` = '%d' WHERE (`id` = '%d')".formatted(trabalhadores.getNome(), trabalhadores.getIdade(), trabalhadores.getId());
        try (Connection conn = ConnectionJDBC.getConnection();
             Statement smt = conn.createStatement()) {
            smt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Trabalhadores> FindAll(){
        String sql = "SELECT * FROM contas.trabalhadores;";
        List<Trabalhadores> trabalhadoresList = new ArrayList<>();
        try (Connection conn = ConnectionJDBC.getConnection();
             Statement smt = conn.createStatement()) {
            ResultSet rs = smt.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                int idade = rs.getInt("idade");
                String nome = rs.getString("Nome");
                Trabalhadores trabalhador = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().id(id).nome(nome).idade(idade).build();
                trabalhadoresList.add(trabalhador);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } return trabalhadoresList;
    }
    public static void FindByName(Trabalhadores trabalhadores){
        List<Trabalhadores> trabalhadoreslista = new ArrayList<>();
        String sql = "SELECT * FROM trabalhadores WHERE nome = '%s';".formatted(trabalhadores.getNome());
        try (Connection conn = ConnectionJDBC.getConnection();
            Statement smt = conn.createStatement()){
            ResultSet rs = smt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("Nome");
                int idade = rs.getInt("idade");
                Trabalhadores trabalhador = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().nome(nome).idade(idade).id(id).build();
                trabalhadoreslista.add(trabalhador);
                System.out.print(trabalhador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

