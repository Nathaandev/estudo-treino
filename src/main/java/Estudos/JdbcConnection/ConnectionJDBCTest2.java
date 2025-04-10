package Estudos.JdbcConnection;
import Estudos.JdbcConnection.Dominio.Trabalhadores;
import Estudos.JdbcConnection.Repository.TrabalhadoresRepository;
import Estudos.JdbcConnection.service.Trabalhadorservice;
import Estudos.JdbcConnection.service.TrabalhadorserviceJDBCRowSet;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class ConnectionJDBCTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.print(TrabalhadorserviceJDBCRowSet.FindByNameJdbcRowSet("car"));
        System.out.print("ID do nome quer você quer mudar: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome: ");
        String Nome = sc.nextLine();
        Trabalhadores trabalhadores = Trabalhadores.TrabalhadoresBuilder.aTrabalhadores()
                .id(id)
                .nome(Nome).build();
        TrabalhadorserviceJDBCRowSet.CachedRowSetupdate(trabalhadores);


    }
}
