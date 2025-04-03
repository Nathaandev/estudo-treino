package Estudos.JdbcConnection;
import Estudos.JdbcConnection.Dominio.Trabalhadores;
import Estudos.JdbcConnection.Repository.TrabalhadoresRepository;
import Estudos.JdbcConnection.service.Trabalhadorservice;
import java.sql.SQLException;
import java.util.Scanner;
public class ConnectionJDBCTest01 {
    public static void main(String[] args ) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Você quer adicionar ou remover dados do banco de dados? (a/r) ");
        String escolha = sc.next();
        if (escolha.equals("a")){
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            Trabalhadores trabalhadores = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().nome(nome).idade(idade).build();
            Trabalhadorservice.save(trabalhadores);
        }
        else if(escolha.equals("r")) {
            System.out.print("Id: ");
            int id = sc.nextInt();
            Trabalhadores trabalhadores = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().id(id).build();
            Trabalhadorservice.delete(id);
        }
    }
}
