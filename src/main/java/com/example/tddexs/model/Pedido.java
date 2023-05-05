package com.example.tddexs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
// @NoArgsConstructor
public class Pedido {
    private int id;
    private String cliente;
    private int quantidadeDeProdutos;
    private Double valorTotal;
    private String estado;

}
