package br.com.srborges.pedidos.processador.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PedidoItemPK {

    @Column(name = "pedido_id")
    private Long pedidoId;

    @Column(name = "produto_id")
    private Long produtoId;
}
