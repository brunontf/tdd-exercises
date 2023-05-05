package com.example.tddexs.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PessoaTest {

    @Test
    public void eDeMaior() {
        Pessoa pessoa = new Pessoa(70);
        assertTrue(pessoa.isAdult(), "true");
    }
    
    @Test
    public void eDeMenor() {
        Pessoa pessoa = new Pessoa(15);
        assertTrue(pessoa.getIdade()<18, "true");
    }
}
