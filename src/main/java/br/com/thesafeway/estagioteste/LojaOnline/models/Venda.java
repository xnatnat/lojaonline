package br.com.thesafeway.estagioteste.LojaOnline.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "ljo_vendas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Venda extends BaseEntity {

    @Column(nullable = false)
    private LocalDateTime dataVenda;

    @OneToMany(mappedBy = "venda")
    private Set<ItemVenda> itensVenda;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private BigDecimal total;
}
