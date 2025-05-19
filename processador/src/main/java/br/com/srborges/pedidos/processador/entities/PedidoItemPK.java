package br.com.srborges.pedidos.processador.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Embeddable
public class PedidoItemPK {

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;

    public PedidoItemPK() {
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidoItemPK that = (PedidoItemPK) o;

        if (!Objects.equals(pedido, that.pedido)) return false;
        return Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        int result = pedido != null ? pedido.hashCode() : 0;
        result = 31 * result + (produto != null ? produto.hashCode() : 0);
        return result;
    }
}
