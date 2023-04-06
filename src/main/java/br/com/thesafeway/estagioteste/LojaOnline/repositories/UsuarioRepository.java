package br.com.thesafeway.estagioteste.LojaOnline.repositories;

import br.com.thesafeway.estagioteste.LojaOnline.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
