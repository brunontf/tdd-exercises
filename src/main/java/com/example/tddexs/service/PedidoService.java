package com.example.tddexs.service;

import com.example.tddexs.model.Pedido;

public class PedidoService {
    public Double calcularFrete(Pedido pedido) {
        Double valorFrete;

        if (pedido.getEstado() == "DF" && pedido.getValorTotal()>100){
            return valorFrete = 0d;
        } else if(pedido.getEstado() != "DF"){
            return valorFrete = 15d;
        }
        return valorFrete = null;
    }

    public Double calcularDescontoValorTotal(Pedido pedido) {
        Double valorComDesconto;
        return valorComDesconto = (pedido.getValorTotal()>500)?pedido.getValorTotal()*0.8:pedido.getValorTotal();
    }
}
