package br.com.srborges.pedidos.api.services;

import br.com.srborges.pedidos.api.dtos.PedidoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class PedidoService {

    private final ModelMapper mapper;
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    public PedidoDTO enfileirarPedido(PedidoDTO pedido) {

        rabbitTemplate.convertAndSend(exchangeName, "", pedido);
        log.info("Pedido enfileirado: {}", pedido.getId());
        return pedido;
    }
}
