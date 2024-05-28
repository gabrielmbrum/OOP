package Serializable;

import java.io.Serializable;

public class Pessoa implements Serializable {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Getters e setters para os atributos
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    // Método toString() para imprimir informações do objeto
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}

