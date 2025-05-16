package br.com.srborges.pedidos.notificacao.listener;

import br.com.srborges.pedidos.notificacao.dtos.PedidoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PedidoListener {

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacaoPedido(PedidoDTO pedidoDTO) {

        log.info("Notificação gerada. Pedido id: {}", pedidoDTO.getId());
    }

}
