package Estudos.junit.service;

import Estudos.junit.dominio.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonServiceTest {
    private Person adult;
    private Person minor;
    private PersonService personService;

    @BeforeEach
    public void setup(){
        adult = new Person(18);
        minor = new Person(15);
        personService = new PersonService();
    }
    @Test
    @DisplayName("A person MUST be 18 or older in order to be considerate an adult.")
    void isAdult() {
        Assertions.assertFalse(personService.isAdult(minor));
    }

    @Test
    @DisplayName("A person MUST be 18 or older in order to be considerate an adult.")
    void isAdult_ReturnTrueWhenAPersonIs18orOlder() {
        Assertions.assertTrue(personService.isAdult(adult));
    }

    @Test
    @DisplayName("Throw nullpointerexception when person is null")
    void isAdult_NullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> personService.isAdult(null) );
    }
}