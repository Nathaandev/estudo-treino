package Estudos.JdbcConnection.service;
import Estudos.JdbcConnection.Dominio.Trabalhadores;
import Estudos.JdbcConnection.Repository.TrabalhadoresRepository;

public class Trabalhadorservice {
    public static void save(Trabalhadores trabalhadores){
        TrabalhadoresRepository.save(trabalhadores);
    }
    public static void delete(int id){
        if (id <= 0){
            throw new IllegalArgumentException("Valor inválido para ID.");
        }
        TrabalhadoresRepository.delete(id);
    }
}
