package br.com.thesafeway.estagioteste.LojaOnline.services;

import br.com.thesafeway.estagioteste.LojaOnline.dtos.VendaDto;
import br.com.thesafeway.estagioteste.LojaOnline.models.ItemVenda;
import br.com.thesafeway.estagioteste.LojaOnline.models.Produto;
import br.com.thesafeway.estagioteste.LojaOnline.models.Venda;
import br.com.thesafeway.estagioteste.LojaOnline.repositories.VendaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Optional;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    private final ItemVendaService itemVendaService;

    public VendaService(VendaRepository vendaRepository, ItemVendaService itemVendaService) {
        this.vendaRepository = vendaRepository;
        this.itemVendaService = itemVendaService;
    }

    public Venda salvarVenda(VendaDto vendaDto) {
        return vendaRepository.save(new Venda(
                LocalDateTime.now(ZoneId.of("UTC")),
                new HashSet<>(),
                vendaDto.getUsuario(),
                new BigDecimal(0)
        ));
    }

    public Venda buscarVenda(Long id){
        return buscarPorId(id).orElseThrow();
    }

    public Venda adicionarItem(Venda venda, Produto produto, Long quantidade) {
        var itemVenda = itemVendaService.salvarItemVenda(venda, produto, quantidade);
        venda.getItensVenda().add(itemVenda);
        itemVenda.setVenda(venda);
        venda.setTotal(venda.getTotal().add(itemVenda.getPreco()));
        return vendaRepository.save(venda);
    }

    public Venda removerItem(Long vendaId, ItemVenda itemVenda) {
        var venda = buscarVenda(vendaId);
        if (venda.getItensVenda().remove(itemVenda)) {
            itemVendaService.deletarItemVenda(itemVenda.getId());
            venda.setTotal(venda.getTotal().subtract(itemVenda.getPreco()));
            vendaRepository.save(venda);
        }
        return venda;
    }

    public void deletarVenda(Long id){
        vendaRepository.delete(buscarVenda(id));
    }

    public Optional<Venda> buscarPorId(Long id) {
        return vendaRepository.findById(id);
    }

}
