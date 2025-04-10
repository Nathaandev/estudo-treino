package Estudos.JdbcConnection;
import Estudos.JdbcConnection.Dominio.Trabalhadores;
import Estudos.JdbcConnection.Repository.TrabalhadoresRepository;
import Estudos.JdbcConnection.service.Trabalhadorservice;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ConnectionJDBCTest03 {
    public static void main(String[] args) throws SQLException {
        Trabalhadores trabalhadores1 = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().nome("MyLove").idade(18).build();
        Trabalhadores trabalhadores2 = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().nome("Lirio").idade(18).build();
        Trabalhadores trabalhadores3 = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().nome("Again and Again").idade(22).build();
        Trabalhadorservice.saveTransaction(List.of(trabalhadores1, trabalhadores2, trabalhadores3));
    }
}
