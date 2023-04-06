package br.com.thesafeway.estagioteste.LojaOnline.dtos;

import br.com.thesafeway.estagioteste.LojaOnline.models.Usuario;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendaDto {
    @NotEmpty
    private Usuario usuario;
}
