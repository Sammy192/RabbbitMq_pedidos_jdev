package br.com.srborges.pedidos.processador.repositories;

import br.com.srborges.pedidos.processador.entities.ItemPedidoEntity;
import br.com.srborges.pedidos.processador.entities.PedidoItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, PedidoItemPK> {
}
