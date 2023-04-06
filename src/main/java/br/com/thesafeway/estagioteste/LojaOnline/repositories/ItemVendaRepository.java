package br.com.thesafeway.estagioteste.LojaOnline.repositories;

import br.com.thesafeway.estagioteste.LojaOnline.models.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
}
