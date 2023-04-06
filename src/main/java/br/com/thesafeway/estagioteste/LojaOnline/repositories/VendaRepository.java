package br.com.thesafeway.estagioteste.LojaOnline.repositories;

import br.com.thesafeway.estagioteste.LojaOnline.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
