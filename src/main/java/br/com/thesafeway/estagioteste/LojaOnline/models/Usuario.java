package br.com.thesafeway.estagioteste.LojaOnline.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Set;

@Entity
@Table(name = "ljo_usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Usuario extends BaseEntity{

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    //@CPF
    private String cpf;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @OneToMany(mappedBy = "usuario")
    private Set<Venda> vendas;

}
