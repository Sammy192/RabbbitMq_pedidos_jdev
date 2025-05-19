package br.com.srborges.pedidos.processador.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoDTO {
    private ProdutoDTO produto;
    private Integer quantidade;
}