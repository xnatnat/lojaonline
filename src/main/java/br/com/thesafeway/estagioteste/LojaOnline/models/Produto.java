package br.com.thesafeway.estagioteste.LojaOnline.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "ljo_produtos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Produto extends BaseEntity{

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private Long quantidade;

    @Column(nullable = false)
    private BigDecimal preco;

    @OneToMany(mappedBy = "produto")
    private Set<ItemVenda> itensVenda;
}
