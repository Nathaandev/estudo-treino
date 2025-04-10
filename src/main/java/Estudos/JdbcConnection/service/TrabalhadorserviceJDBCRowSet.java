package Estudos.JdbcConnection.service;
import Estudos.JdbcConnection.Dominio.Trabalhadores;
import Estudos.JdbcConnection.Repository.TrabalhadoresRepository;
import Estudos.JdbcConnection.Repository.TrabalhadoresRepositoryRowSet;

import java.util.List;

public class TrabalhadorserviceJDBCRowSet {
    public static List<Trabalhadores> FindByNameJdbcRowSet(String Nome){
        return TrabalhadoresRepositoryRowSet.FindByNameJdbcRowSet(Nome);
    }
    public static void update(Trabalhadores trabalhadores){
        TrabalhadoresRepositoryRowSet.update(trabalhadores);
    }
    public static void CachedRowSetupdate(Trabalhadores trabalhadores){
        TrabalhadoresRepositoryRowSet.CachedRowSetupdate(trabalhadores);
    }
}
