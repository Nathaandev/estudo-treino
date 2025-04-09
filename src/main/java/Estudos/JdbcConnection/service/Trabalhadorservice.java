package Estudos.JdbcConnection.service;
import Estudos.JdbcConnection.Dominio.Trabalhadores;
import Estudos.JdbcConnection.Repository.TrabalhadoresRepository;

import java.util.List;

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
    public static void update(Trabalhadores trabalhadores){
        TrabalhadoresRepository.update(trabalhadores);
    }
    public static List<Trabalhadores> FindAll(){
        return TrabalhadoresRepository.FindAll();
    }
    public static void FindByName(Trabalhadores trabalhadores){
        TrabalhadoresRepository.FindByName(trabalhadores);
    }
    public static void GetMetaData(){
        TrabalhadoresRepository.getMetaData();
    }
    public static void AtualizarDados(String Nome){
        TrabalhadoresRepository.AtualizarDados(Nome);
    }
    public static void DriverMetadata(){
        TrabalhadoresRepository.DriverMetadata();
    }
    public static void FindByNamePrepareStatement(String Nome){
        TrabalhadoresRepository.FindByNamePrepareStatement(Nome);
    }
}
