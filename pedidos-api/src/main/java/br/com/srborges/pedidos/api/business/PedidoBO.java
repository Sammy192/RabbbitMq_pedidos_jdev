package br.com.srborges.pedidos.api.business;

import br.com.srborges.pedidos.api.enums.StatusPedido;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoBO {

    private Long id;
    private String cliente;
    private List<ItemPedidoBO> itens = new ArrayList<>();
    private Double valorTotal;
    private String emailNotificacao;
    private StatusPedido status;
    private LocalDateTime dataHoraPedido;
}
