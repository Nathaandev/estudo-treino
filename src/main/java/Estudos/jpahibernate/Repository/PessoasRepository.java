package Estudos.jpahibernate.Repository;
import Estudos.jpahibernate.Dominio.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;
public class PessoasRepository {
    static Scanner sc = new Scanner(System.in);
    public static void AdicionarPessoa() {
        EntityManagerFactory Entfac = Persistence.createEntityManagerFactory("jpaestudo");
        EntityManager Ent = Entfac.createEntityManager();
        System.out.print("Name: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        Pessoa pessoa = new Pessoa(nome, email, null);
        Ent.getTransaction().begin();
        Ent.persist(pessoa);
        Ent.getTransaction().commit();
        Ent.close();
        Entfac.close();
    }
    public static void RemoverPessoa() {
        EntityManagerFactory Entfac = Persistence.createEntityManagerFactory("jpaestudo");
        EntityManager Ent = Entfac.createEntityManager();
        System.out.print("Id: ");
        Integer id = sc.nextInt();
        Pessoa find = Ent.find(Pessoa.class, id);
        Ent.getTransaction().begin();
        Ent.remove(find);
        Ent.getTransaction().commit();
        Ent.close();
        Entfac.close();
    }
    public static void VisualizarPessoa(){
        EntityManagerFactory Entfac = Persistence.createEntityManagerFactory("jpaestudo");
        EntityManager Ent = Entfac.createEntityManager();
        System.out.print("Id: ");
        Integer id = sc.nextInt();
        Ent.getTransaction().begin();
        Pessoa find = Ent.find(Pessoa.class, id);
        System.out.print(find);
        Ent.getTransaction().commit();
    }
    public static void AtualizarPessoa(){
        EntityManagerFactory Entfac = Persistence.createEntityManagerFactory("jpaestudo");
        EntityManager Ent = Entfac.createEntityManager();
        System.out.print("Id: ");
        Integer id = sc.nextInt();
        sc.nextLine();
        System.out.print("New Name: ");
        String nome = sc.nextLine();
        System.out.print("New Email: ");
        String email = sc.nextLine();
        Ent.getTransaction().begin();
        Pessoa find = Ent.find(Pessoa.class, id);
        find.setNome(nome);
        find.setEmail(email);
        Ent.getTransaction().commit();
        Ent.close();
        Entfac.close();
    }
}
