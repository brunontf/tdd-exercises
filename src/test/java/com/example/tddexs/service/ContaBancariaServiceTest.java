package com.example.tddexs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.tddexs.model.Conta;

public class ContaBancariaServiceTest {
    ContaBancariaService contaBancariaService = new ContaBancariaService();

    // depositar: recebe um valor e adiciona esse valor ao saldo da conta.
    @Test
    public void depositarValor() {
        Conta conta = new Conta(100d);
        
        Double saldo = conta.getSaldo();
        Double valorDepositado = 10.15;
        contaBancariaService.depositar(conta, valorDepositado);
        assertEquals(conta.getSaldo(), saldo+valorDepositado);

        // nao permite depositar valores nulos ou negativos
        saldo = conta.getSaldo();
        valorDepositado = -50d;
        contaBancariaService.depositar(conta, valorDepositado);
        assertEquals(saldo, conta.getSaldo());

    }
    // sacar: recebe um valor e subtrai esse valor do saldo da conta, 
    // desde que o saldo seja suficiente. Caso contrário, deve lançar 
    // uma exceção SaldoInsuficienteException.
    @Test
    public void sacarValor() {
        Conta conta = new Conta(100d);
        Double saldo = conta.getSaldo();
        Double valorASacar = 30d;
        contaBancariaService.sacar(conta,valorASacar);
        assertEquals(70, conta.getSaldo());

        saldo = conta.getSaldo();
        valorASacar = 300d;
        // contaBancariaService.sacar(conta,valorASacar);
        // assertEquals(saldo, conta.getSaldo());
        assertThrows(IllegalArgumentException.class,()-> contaBancariaService.sacar(conta,300d));
        
        saldo = conta.getSaldo();
        valorASacar = -80d;
        // contaBancariaService.sacar(conta,valorASacar);
        assertThrows(IllegalArgumentException.class,()-> contaBancariaService.sacar(conta,-80d));
        // assertEquals(saldo, conta.getSaldo());


    }
    // transferir: recebe uma conta de destino e um valor, e 
    // transfere esse valor da conta atual para a conta de destino.
    @Test
    public void transferirValor() {
        Conta contaDestino = new Conta(30d);
        Conta contaAtual = new Conta(100d);
        Double saldoDestino = contaDestino.getSaldo();
        Double saldoAtual = contaDestino.getSaldo();
        Double valorASerTransferido = 10d;
        contaBancariaService.transferir(contaDestino, contaAtual, valorASerTransferido);
        assertEquals(90d, contaAtual.getSaldo());
        assertEquals(40d, contaDestino.getSaldo());
        
        saldoDestino = contaDestino.getSaldo();
        saldoAtual = contaDestino.getSaldo();
        valorASerTransferido = 100d;
        contaBancariaService.transferir(contaDestino, contaAtual, valorASerTransferido);
        assertEquals(90d, contaAtual.getSaldo());
        assertEquals(40d, contaDestino.getSaldo());
        
        saldoDestino = contaDestino.getSaldo();
        saldoAtual = contaDestino.getSaldo();
        valorASerTransferido = -200d;
        contaBancariaService.transferir(contaDestino, contaAtual, valorASerTransferido);
        assertEquals(90d, contaAtual.getSaldo());
        assertEquals(40d, contaDestino.getSaldo());



    }
}
