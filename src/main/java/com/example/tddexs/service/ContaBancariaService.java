package com.example.tddexs.service;

import com.example.tddexs.model.Conta;

public class ContaBancariaService {

    public void depositar(Conta conta, Double valorDepositado) {
        if(valorDepositado>0){
            conta.setSaldo(conta.getSaldo()+valorDepositado);
        }
    }

    public void sacar(Conta conta, Double valorASacar) {
        if(conta.getSaldo()>= valorASacar && valorASacar>0){
            conta.setSaldo(conta.getSaldo()-valorASacar);
        } else if (valorASacar<=0){
            throw new IllegalArgumentException("Não é possível sacar valores negativos");
        } else{
            throw new IllegalArgumentException("Saldo Insuficiente");

        }
    }

    public void transferir(Conta contaDestino, Conta contaAtual, Double valorASerTransferido) {
        if(contaAtual.getSaldo()>=valorASerTransferido && valorASerTransferido>0){
            contaAtual.setSaldo(contaAtual.getSaldo()-valorASerTransferido);
            contaDestino.setSaldo(contaDestino.getSaldo()+valorASerTransferido);
        }
    }
    
}
