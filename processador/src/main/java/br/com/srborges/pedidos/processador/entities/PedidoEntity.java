package br.com.srborges.pedidos.processador.entities;

import br.com.srborges.pedidos.processador.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    private Long id;
    private String cliente;

    @OneToMany(mappedBy = "id.pedido")
    private List<ItemPedidoEntity> itens;

    private Double valorTotal;
    private String emailNotificacao;

    @Enumerated(EnumType.STRING)
    private StatusPedido status = StatusPedido.EM_PROCESSAMENTO;

    //@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataHoraPedido = LocalDateTime.now();
}