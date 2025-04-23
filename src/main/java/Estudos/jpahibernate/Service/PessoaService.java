package Estudos.jpahibernate.Service;
import Estudos.jpahibernate.Repository.PessoasRepository;
import Estudos.jpahibernate.Dominio.Pessoa;

public class PessoaService {

    public static void MenuBuilder(int menu){
        switch (menu){
            case 1:
                PessoasRepository.AdicionarPessoa();;
                break;

            case 2:
                PessoasRepository.RemoverPessoa();
                break;
            case 3:
                PessoasRepository.VisualizarPessoa();
                break;
            case 4:
                PessoasRepository.AtualizarPessoa();
                break;
        }
    }
    public static void MostrarNome(){
        PessoasRepository.AdicionarPessoa();
    }
}
