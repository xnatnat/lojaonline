package br.com.thesafeway.estagioteste.LojaOnline.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ljo_item_vendas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ItemVenda extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private Long quantidade;

    @Column(nullable = false)
    private BigDecimal preco;
}
