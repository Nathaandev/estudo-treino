package Estudos.crud.service;
import Estudos.crud.dominio.Trabalhadores;
import Estudos.crud.repository.Repository;

import java.util.List;
import java.util.Scanner;

public class TrabalhadorService {
    private static Scanner sc = new Scanner(System.in);

    public static void MenuBuilder(int menu){
        switch (menu){
            case 1:
                FindByName();
                break;

            case 2:
                delete();
                break;

            case 3:
                save();
                break;
            case 4:
                update();
                break;
        }
    }
    public static void FindByName(){
        System.out.println("");
        System.out.println("Search for a name (leave the space in black if you want to find all names.");
        String Nome = sc.nextLine();
        List<Trabalhadores> trabalhadoresList = Repository.FindByNamePrepareStatement(Nome);
        for (int i = 0; i < trabalhadoresList.size() ; i++) {
            System.out.printf("(%d), %s\n", i + 1, trabalhadoresList.get(i).getNome());
        }
    }
    public static void delete(){
        System.out.print("Choose and ID to delete: ");
        int id = sc.nextInt();
        Repository.delete(id);
    }
    public static void save(){
        System.out.print("Digit the worker's name: ");
        String Nome = sc.nextLine();
        System.out.print("Digite the worker's age: ");
        int idade = sc.nextInt();
        Repository.save(Nome, idade);
    }
    public static void update(){
        System.out.println("Enter the id you want to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the person's new name: ");
        String Nome = sc.nextLine();
        System.out.println("Enter the person's new age: ");
        int idade = sc.nextInt();
        Repository.update(Nome, idade, id);

    }
}
