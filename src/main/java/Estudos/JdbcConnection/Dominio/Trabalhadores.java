package Estudos.JdbcConnection.Dominio;

import java.util.Objects;

public class Trabalhadores {

    private int id;
    private String nome;
    private int idade;


    public static final class TrabalhadoresBuilder {
        private int id;
        private String nome;
        private int idade;

        public TrabalhadoresBuilder() {
        }

        public static TrabalhadoresBuilder aTrabalhadores() {
            return new TrabalhadoresBuilder();
        }

        public TrabalhadoresBuilder id(int id) {
            this.id = id;
            return this;
        }

        public TrabalhadoresBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public TrabalhadoresBuilder idade(int idade) {
            this.idade = idade;
            return this;
        }

        public Trabalhadores build() {
            Trabalhadores trabalhadores = new Trabalhadores();
            trabalhadores.id = this.id;
            trabalhadores.idade = this.idade;
            trabalhadores.nome = this.nome;
            return trabalhadores;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Trabalhadores that = (Trabalhadores) o;
        return id == that.id && idade == that.idade && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, idade);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
