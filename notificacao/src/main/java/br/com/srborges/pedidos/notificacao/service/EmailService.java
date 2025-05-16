package br.com.srborges.pedidos.notificacao.service;

import br.com.srborges.pedidos.notificacao.dtos.PedidoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;

    public void enviarEmail(PedidoDTO pedidoDTO) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("pedidos-api@companny.com");
        simpleMailMessage.setTo(pedidoDTO.getEmailNotificacao());
        simpleMailMessage.setSubject("Pedido de Compra");
        simpleMailMessage.setText(this.gerarMensagem(pedidoDTO));
        emailSender.send(simpleMailMessage);
    }

    private String gerarMensagem(PedidoDTO pedido) {
        String pedidoId = pedido.getId().toString();
        String cliente = pedido.getCliente();
        String valor = String.valueOf(pedido.getValorTotal());
        String status = pedido.getStatus().name();
        return String.format("Olá %s seu pedido de nº %s no valor de %s, foi realizado com sucesso.%nStatus: %s.", cliente, pedidoId, valor, status);
    }
}
