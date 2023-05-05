package com.example.tddexs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.tddexs.model.Pedido;

public class PedidoServiceTest {
    PedidoService pedidoService = new PedidoService();
    
    @Test
    public void calculaFreteForaDF() {
        Pedido pedido1 = new Pedido(1, "Jonh Doe", 12, 10d, "DF");
        Double valorFrete1 = pedidoService.calcularFrete(pedido1);
        assertEquals(null, valorFrete1);
        Pedido pedido2 = new Pedido(2, "Jonh Doe", 1, 10d, "SP");
        Double valorFrete2 = pedidoService.calcularFrete(pedido2);
        assertEquals(15d, valorFrete2);
    }
    @Test
    public void freteDFAcimaDe100() {
        Pedido pedido1 = new Pedido(1, "Jonh Doe", 12, 1000d, "DF");
        Double valorFrete1 = pedidoService.calcularFrete(pedido1);
        assertEquals(0, valorFrete1);
        Pedido pedido2 = new Pedido(2, "Jonh Doe", 12, 90.23, "DF");
        Double valorFrete2 = pedidoService.calcularFrete(pedido2);
        assertEquals(null, valorFrete2);
        Pedido pedido3 = new Pedido(3, "Jonh Doe", 12, 100.23, "SP");
        Double valorFrete3 = pedidoService.calcularFrete(pedido3);
        assertEquals(15d, valorFrete3);
        
    }
    @Test
    public void descontoAcimaDe500() {
        Pedido pedido1 = new Pedido(1, "Jonh Doe", 12, 1000d, "DF");
        Double valorComDesconto1 = pedidoService.calcularDescontoValorTotal(pedido1);
        assertEquals(pedido1.getValorTotal()*0.8, valorComDesconto1);
        Pedido pedido2 = new Pedido(2, "Jonh Doe", 12, 100d, "DF");
        Double valorComDesconto2 = pedidoService.calcularDescontoValorTotal(pedido2);
        assertEquals(pedido2.getValorTotal(), valorComDesconto2);
        
    }
}
