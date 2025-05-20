package br.com.srborges.pedidos.processador.listener;

import br.com.srborges.pedidos.processador.dtos.PedidoDTO;
import br.com.srborges.pedidos.processador.services.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PedidoListener {

    private final PedidoService pedidoService;

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-processamento")
    public void salvarPedido(PedidoDTO pedido) {
        log.info("Pedido recebido: {}", pedido.getId());
        pedidoService.save(pedido);
        log.info("Pedido salvo com sucesso: {}", pedido.getId());
    }
}
