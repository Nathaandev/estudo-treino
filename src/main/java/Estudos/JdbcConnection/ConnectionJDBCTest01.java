package Estudos.JdbcConnection;
import Estudos.JdbcConnection.Dominio.Trabalhadores;
import Estudos.JdbcConnection.Repository.TrabalhadoresRepository;
import Estudos.JdbcConnection.service.Trabalhadorservice;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class ConnectionJDBCTest01 {
    public static void main(String[] args ) throws SQLException {
        Scanner sc = new Scanner(System.in);
        List<Trabalhadores> trabalhadoresall = Trabalhadorservice.FindAll();
        System.out.print("1| Adicionar\n2| Remover\n3| Atualizar dados\n4| Achar dados pelo nome\n5| Achar todos os dados da tabela ");
        int escolha = sc.nextInt();
        if (escolha == 1){
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            Trabalhadores trabalhadores = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().nome(nome).idade(idade).build();
            Trabalhadorservice.save(trabalhadores);
        }
        else if(escolha == 4) {
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            Trabalhadores trabalhadores = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().nome(nome).build();
            Trabalhadorservice.FindByName(trabalhadores);
        }
        else if(escolha == 2) {
            System.out.print("Id: ");
            int id = sc.nextInt();
            Trabalhadores trabalhadores = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().id(id).build();
            Trabalhadorservice.delete(id);
        } else if (escolha == 3){
            System.out.print("Id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            Trabalhadores trabalhadores = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores().id(id).nome(nome).idade(idade).build();
            Trabalhadorservice.update(trabalhadores);
        }
        else if (escolha == 5){
            System.out.print(trabalhadoresall);
        }

    }
}
