package Estudos.JdbcConnection;
import Estudos.JdbcConnection.Dominio.Trabalhadores;
import Estudos.JdbcConnection.Repository.TrabalhadoresRepository;
import java.sql.SQLException;
import java.util.Scanner;
public class ConnectionJDBCTest01 {
    public static void main(String[] args ) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("Idade: ");
        int Idade = sc.nextInt();
        Trabalhadores trabalhadores = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().nome(name).idade(Idade).build();
        TrabalhadoresRepository.save(trabalhadores);
    }
}
