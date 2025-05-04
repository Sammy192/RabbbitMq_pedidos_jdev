package br.com.srborges.pedidos.api.services;

import br.com.srborges.pedidos.api.business.PedidoBO;
import br.com.srborges.pedidos.api.dtos.PedidoDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class PedidoService {

    private final ModelMapper mapper;
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    public PedidoDTO enfileirarPedido(PedidoDTO pedido) {
        PedidoBO pedidoBO = mapper.map(pedido, PedidoBO.class);

        rabbitTemplate.convertAndSend(exchangeName, "", pedido);
        log.info("Pedido enfileirado: {}", pedido.getId());
        return mapper.map(pedidoBO, PedidoDTO.class);
    }
}
