package br.com.srborges.pedidos.api.controllers;

import br.com.srborges.pedidos.api.dtos.PedidoDTO;
import br.com.srborges.pedidos.api.services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pedidos")
@AllArgsConstructor
@Tag(name = "Pedidos", description = "API para gerenciamento de pedidos"  )
public class PedidoController {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(PedidoController.class);
    private PedidoService pedidoService;

    @Operation(summary = "Cria um novo pedido", description = "Recurso para criar um novo pedido",
            responses = {@ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PedidoDTO.class)))
            })
    @PostMapping
    private ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO pedido) {
        logger.info("Pedido id recebido: {}", pedido.getId());
        PedidoDTO pedidoCriado = pedidoService.criarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoCriado);
    }
}
