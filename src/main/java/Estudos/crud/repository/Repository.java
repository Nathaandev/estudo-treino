package Estudos.crud.repository;
import Estudos.crud.conn.ConnectionJDBC;
import Estudos.crud.dominio.Trabalhadores;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static List<Trabalhadores> FindByNamePrepareStatement(String Nome){
        List<Trabalhadores> trabalhadoreslista = new ArrayList<>();
        String sql = "SELECT * FROM trabalhadores WHERE Nome like ?;";
        try (Connection conn = Estudos.crud.conn.ConnectionJDBC.getConnection();
             PreparedStatement smt = createdPreparedStatement(conn, sql, Nome);
             ResultSet rs = smt.executeQuery();){

            while (rs.next()){
               int id = rs.getInt("id");
               String nome = rs.getString("Nome");
                int idade = rs.getInt("idade");
                Trabalhadores trabalhador = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().nome(nome).idade(idade).id(id).build();
                trabalhadoreslista.add(trabalhador);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trabalhadoreslista;
    }
    private static PreparedStatement createdPreparedStatement(Connection conn, String sql, String Nome) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", Nome));
        return ps;

    }

    public static void delete(int id) {

        try (Connection conn = Estudos.crud.conn.ConnectionJDBC.getConnection();
             PreparedStatement smt = createdPreparedDelete(conn,  id)) {
            smt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static PreparedStatement createdPreparedDelete(Connection conn,  int id)throws SQLException{
        String sqldelete = "DELETE FROM `contas`.`trabalhadores` WHERE (`id` = ?)";
        PreparedStatement ps = conn.prepareStatement(sqldelete);
        ps.setInt(1, id);
        return ps;
    }

    public static void save(String Nome, int idade){
        try (Connection conn = Estudos.crud.conn.ConnectionJDBC.getConnection();
        PreparedStatement smt = createdPreparedSave(conn, Nome, idade)){
            smt.execute();
        }  catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static PreparedStatement createdPreparedSave(Connection conn, String Nome, int idade) throws SQLException{
        String sqlsave = "INSERT INTO `contas`.`trabalhadores` (`Nome`, `idade`) VALUES (?, ?);";
        PreparedStatement ps = conn.prepareStatement(sqlsave);
        ps.setString(1, Nome);
        ps.setInt(2, idade);
        return ps;
    }
    private static PreparedStatement createdPreparedUpdate(Connection conn, int id, String Nome, int idade)throws SQLException{
        String sqlupdate = "UPDATE `contas`.`trabalhadores` SET `Nome` = ?, `idade` = ? WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sqlupdate);
        ps.setString(1, Nome);
        ps.setInt(2, idade);
        ps.setInt(3, id);
        return ps;
    }
    public static void update(String Nome, int idade, int id){
        try(Connection conn = Estudos.crud.conn.ConnectionJDBC.getConnection();
        PreparedStatement smt = createdPreparedUpdate(conn, id, Nome, idade)){
            smt.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
