package br.com.srborges.pedidos.processador.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    private Long id;
    private String nome;
    private Double valor;

    @JsonIgnore
    @ToString.Exclude
    //@Transient
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedidoEntity> itensPedido = new ArrayList<>();
}