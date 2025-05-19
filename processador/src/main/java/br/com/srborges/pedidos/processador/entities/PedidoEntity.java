package br.com.srborges.pedidos.processador.entities;

import br.com.srborges.pedidos.processador.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;
    private Long idPedido;
    private String cliente;

    @ToString.Exclude
    @OneToMany(mappedBy = "id.pedido")
    private List<ItemPedidoEntity> itens = new ArrayList<>();

    private Double valorTotal;
    private String emailNotificacao;

    @Enumerated(EnumType.STRING)
    private StatusPedido status = StatusPedido.EM_PROCESSAMENTO;

    //@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataHoraPedido = LocalDateTime.now();
}