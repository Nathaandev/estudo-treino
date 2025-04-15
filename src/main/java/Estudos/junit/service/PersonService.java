package Estudos.junit.service;
import Estudos.junit.dominio.Person;
import java.util.Objects;

public class PersonService {
    public boolean isAdult(Person person){
        Objects.requireNonNull(person, "Person cannot be null.");
        return person.getAge() >= 18;
    }
}
