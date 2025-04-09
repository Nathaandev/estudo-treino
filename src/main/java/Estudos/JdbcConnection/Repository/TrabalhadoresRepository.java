package Estudos.JdbcConnection.Repository;
import Estudos.JdbcConnection.ConnectionJDBC;
import Estudos.JdbcConnection.Dominio.Trabalhadores;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
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
    public static void getMetaData(){
        List<Trabalhadores> trabalhadoreslista = new ArrayList<>();
        String sql = "SELECT * FROM trabalhadores";
        try (Connection conn = ConnectionJDBC.getConnection();
             Statement smt = conn.createStatement()){
            ResultSet rs = smt.executeQuery(sql);
            ResultSetMetaData rsMetaData = rs.getMetaData();
            rs.next();
            int colunas = rsMetaData.getColumnCount();
            for (int i = 1 ; i <= colunas; i++ ){
                System.out.printf("Existem %d colunas.\n", colunas);
                System.out.printf("Nome da coluna: %s\n", rsMetaData.getCatalogName(i));
                System.out.print("Tipo da coluna: "+ rsMetaData.getColumnType(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void AtualizarDados(String Nome){
        String sql = "SELECT * FROM contas.trabalhadores where Nome like '%s%%';\n".formatted(Nome);
        try (Connection conn = ConnectionJDBC.getConnection();
        Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
           ResultSet rs = smt.executeQuery(sql);
           while (rs.next()){
              rs.updateString("Nome",rs.getString("Nome").toLowerCase());
              rs.updateRow();

           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void DriverMetadata(){
        String sql = "SELECT * FROM trabalhadores";
        try (Connection conn = ConnectionJDBC.getConnection()) {
            DatabaseMetaData dbMetadata = conn.getMetaData();
            if (dbMetadata.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)){
                System.out.println("Supports TYPE_FORWARD_ONLY");
                if(dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                    System.out.println("And supports CONCUR_UPDATABLE");
                }
            }
            if (dbMetadata.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)){
                System.out.println("Supports TYPE_SCROLL_INSENSITIVE");
                if(dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    System.out.println("And supports CONCUR_UPDATABLE");
                }
            }
            if (dbMetadata.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)){
                System.out.println("Supports TYPE_SCROLL_INSENSITIVE");
                if(dbMetadata.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    System.out.println("And supports CONCUR_UPDATABLE");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void FindByNamePrepareStatement(String Nome){
        List<Trabalhadores> trabalhadoreslista = new ArrayList<>();
        String sql = "SELECT * FROM trabalhadores WHERE Nome like ?;";
        try (Connection conn = ConnectionJDBC.getConnection();
             PreparedStatement smt = createdPreparedStatement(conn, sql, Nome);
             ResultSet rs = smt.executeQuery();){

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
    private static PreparedStatement createdPreparedStatement(Connection conn, String sql, String Nome) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", Nome));
        return ps;

    }
}

