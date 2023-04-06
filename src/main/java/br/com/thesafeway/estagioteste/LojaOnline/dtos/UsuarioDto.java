package br.com.thesafeway.estagioteste.LojaOnline.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    //@CPF
    private String cpf;

    @NotBlank
    @Email
    private String email;
}
