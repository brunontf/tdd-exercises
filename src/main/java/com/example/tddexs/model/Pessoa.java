package com.example.tddexs.model;

public class Pessoa {
    private int idade;

    public Pessoa(int idade) {
        this.idade = idade;
    }

    public boolean isAdult() {
        boolean age;
        return age = idade>=18 ? true : false;
    }

    public int getIdade() {
        return idade;
    }
}
