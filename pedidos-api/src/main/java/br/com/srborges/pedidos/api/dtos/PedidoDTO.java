package br.com.srborges.pedidos.api.dtos;

import br.com.srborges.pedidos.api.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private String cliente;
    private List<ItemPedidoDTO> itens;
    private Double valorTotal;
    private String emailNotificacao;
    private StatusPedido status = StatusPedido.EM_PROCESSAMENTO;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataHoraPedido = LocalDateTime.now();
}