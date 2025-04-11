package Estudos.crud;

import Estudos.crud.dominio.Trabalhadores;
import Estudos.crud.repository.Repository;
import Estudos.crud.service.TrabalhadorService;
import java.util.Scanner;
import java.sql.SQLException;

public class test {
    public static void main(String[] args ) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Repository.update("Carlos da silva", 20, 9);
        System.out.println("1. Find data per name.\n2. Delete data.\n3. Add data.\n4. Update data.");
        int menu = sc.nextInt();
        TrabalhadorService.MenuBuilder(menu);

    }
}
