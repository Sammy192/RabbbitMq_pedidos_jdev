package br.com.srborges.pedidos.api.business;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemPedidoBO {

    private ProdutoBO produto;
    private Integer quantidade;
}
