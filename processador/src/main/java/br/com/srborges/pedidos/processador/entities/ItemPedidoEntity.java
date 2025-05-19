package br.com.srborges.pedidos.processador.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
@Table(name = "item_pedido")
public class ItemPedidoEntity {

    @EmbeddedId
    private PedidoItemPK id = new PedidoItemPK();
    private Integer quantidade;
    private Double valor;

    public ItemPedidoEntity() {
    }

    public ItemPedidoEntity(PedidoEntity pedido, ProdutoEntity produto, Integer quantidade, Double valor) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.valor = valor;
    }
}