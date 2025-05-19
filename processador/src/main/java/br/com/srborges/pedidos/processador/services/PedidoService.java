package br.com.srborges.pedidos.processador.services;

import br.com.srborges.pedidos.processador.dtos.ItemPedidoDTO;
import br.com.srborges.pedidos.processador.dtos.PedidoDTO;
import br.com.srborges.pedidos.processador.entities.ItemPedidoEntity;
import br.com.srborges.pedidos.processador.entities.PedidoEntity;
import br.com.srborges.pedidos.processador.entities.ProdutoEntity;
import br.com.srborges.pedidos.processador.enums.StatusPedido;
import br.com.srborges.pedidos.processador.repositories.ItemPedidoRepository;
import br.com.srborges.pedidos.processador.repositories.PedidoRepository;
import br.com.srborges.pedidos.processador.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private ModelMapper mapper = new ModelMapper();
    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    @Transactional
    public void save(PedidoDTO pedidoDTO) {

        PedidoEntity pedidoEntity = copiaDadosDoDtoParaEntidade(pedidoDTO);

        for(ItemPedidoDTO itemDTO : pedidoDTO.getItens()) {
            //se produto ja existir na base
            //ProdutoEntity produtoEntity = produtoRepository.getReferenceById(itemDTO.getProduto().getId());

            ProdutoEntity produtoEntity = new ProdutoEntity(itemDTO.getProduto().getId(), itemDTO.getProduto().getNome(), itemDTO.getProduto().getValor());
            produtoEntity = produtoRepository.save(produtoEntity);

            ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity(pedidoEntity, produtoEntity, itemDTO.getQuantidade(), produtoEntity.getValor());
            pedidoEntity.getItens().add(itemPedidoEntity);
        }
        pedidoEntity.setStatus(StatusPedido.PROCESSADO);

        pedidoRepository.save(pedidoEntity);
        itemPedidoRepository.saveAll(pedidoEntity.getItens());

    }

    private PedidoEntity copiaDadosDoDtoParaEntidade(PedidoDTO pedidoDTO) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setIdPedido(pedidoDTO.getId());
        pedidoEntity.setCliente(pedidoDTO.getCliente());
        pedidoEntity.setValorTotal(pedidoDTO.getValorTotal());
        pedidoEntity.setEmailNotificacao(pedidoDTO.getEmailNotificacao());
        pedidoEntity.setStatus(pedidoDTO.getStatus());
        pedidoEntity.setDataHoraPedido(pedidoDTO.getDataHoraPedido());
        return pedidoEntity;
    }
}
