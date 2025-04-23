package Estudos.jpahibernate.Application;
import Estudos.jpahibernate.Dominio.Pessoa;
import Estudos.jpahibernate.Service.PessoaService;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu = sc.nextInt();
        PessoaService.MenuBuilder(menu);
    }
}
