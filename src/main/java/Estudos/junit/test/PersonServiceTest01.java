package Estudos.junit.test;

import Estudos.junit.dominio.Person;
import Estudos.junit.service.PersonService;

public class PersonServiceTest01 {
    public static void main(String[] args) {
        Person person = new Person(18);
        PersonService personService = new PersonService();
        System.out.println(personService.isAdult(person));
    }
}
