package br.com.srborges.pedidos.api.business;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoBO {
    private Long id;
    private String nome;
    private Double valor;
}
