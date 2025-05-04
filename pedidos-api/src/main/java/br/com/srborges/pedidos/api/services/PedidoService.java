package br.com.srborges.pedidos.api.services;

import br.com.srborges.pedidos.api.business.PedidoBO;
import br.com.srborges.pedidos.api.dtos.PedidoDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class PedidoService {

    private final ModelMapper mapper;

    public PedidoDTO criarPedido(PedidoDTO pedido) {
        PedidoBO pedidoBO = mapper.map(pedido, PedidoBO.class);

        log.info("Criando novo pedido: {}", pedidoBO);
        // Implementar a criação do pedido
        //...
        return mapper.map(pedidoBO, PedidoDTO.class);
    }
}
