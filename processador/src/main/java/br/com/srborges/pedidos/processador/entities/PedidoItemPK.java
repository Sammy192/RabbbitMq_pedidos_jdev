package br.com.srborges.pedidos.processador.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
@Embeddable
@NoArgsConstructor
public class PedidoItemPK {

    @ManyToOne
    @JoinColumn(name = "pedido_pk")
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;
}
