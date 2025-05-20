package br.com.srborges.pedidos.processador.entities;

import br.com.srborges.pedidos.processador.dtos.ProdutoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@Entity
@Table(name = "item_pedido")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoEntity {

    @EmbeddedId
    private PedidoItemPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pedidoId")
    private PedidoEntity pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("produtoId")
    private ProdutoEntity produto;

    private Integer quantidade;

    public ItemPedidoEntity(PedidoEntity pedido, ProdutoEntity produto, Integer quantidade) {
        this.id = new PedidoItemPK(pedido.getId(), produto.getId());
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }
}