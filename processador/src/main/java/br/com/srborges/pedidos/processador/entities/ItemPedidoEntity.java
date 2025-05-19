package br.com.srborges.pedidos.processador.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

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

    public PedidoEntity getPedido() {
        return id.getPedido();
    }

    public void setOrder(PedidoEntity order) {
        id.setPedido(order);
    }

    public ProdutoEntity getProduct() {
        return id.getProduto();
    }

    public void setProduct(ProdutoEntity produto) {
        id.setProduto(produto);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantity(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemPedidoEntity orderItem = (ItemPedidoEntity) o;

        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}