package br.com.srborges.pedidos.processador.repositories;

import br.com.srborges.pedidos.processador.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
