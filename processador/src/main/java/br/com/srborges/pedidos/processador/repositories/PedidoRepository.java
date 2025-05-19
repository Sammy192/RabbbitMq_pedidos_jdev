package br.com.srborges.pedidos.processador.repositories;

import br.com.srborges.pedidos.processador.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
