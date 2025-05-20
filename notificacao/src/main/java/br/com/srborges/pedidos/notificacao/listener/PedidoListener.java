package br.com.srborges.pedidos.notificacao.listener;

import br.com.srborges.pedidos.notificacao.dtos.PedidoDTO;
import br.com.srborges.pedidos.notificacao.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PedidoListener {

    private final EmailService emailService;

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacaoPedido(PedidoDTO pedidoDTO) {
        log.info("Inicio da notificação de novo pedido. Pedido id: {}", pedidoDTO.getId());
        /*if(pedidoDTO.getValorTotal() > 100) {
            throw new RuntimeException("teste");
        }*/

        emailService.enviarEmail(pedidoDTO);
        log.info("Notificação gerada. Pedido id: {}", pedidoDTO.getId());
    }
}
