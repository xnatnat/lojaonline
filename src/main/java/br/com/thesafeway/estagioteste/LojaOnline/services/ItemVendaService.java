package br.com.thesafeway.estagioteste.LojaOnline.services;

import br.com.thesafeway.estagioteste.LojaOnline.models.ItemVenda;
import br.com.thesafeway.estagioteste.LojaOnline.models.Produto;
import br.com.thesafeway.estagioteste.LojaOnline.models.Venda;
import br.com.thesafeway.estagioteste.LojaOnline.repositories.ItemVendaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ItemVendaService {

    private final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

    public ItemVenda salvarItemVenda(Venda venda, Produto produto, Long quantidade){
        return itemVendaRepository.save(new ItemVenda(
                venda, produto,
                quantidade,
                produto.getPreco().multiply(BigDecimal.valueOf(quantidade))));
    }

    public ItemVenda buscarItemVenda(Long id){
        return buscarPorId(id).orElseThrow();
    }

    public ItemVenda editarqQuantidadeItemVenda(Long id, Long quantidade){
        var itemVenda = buscarItemVenda(id);
        itemVenda.setQuantidade(quantidade);
        itemVenda.setPreco(itemVenda.getProduto().getPreco().multiply(BigDecimal.valueOf(quantidade)));
        return itemVendaRepository.save(itemVenda);
    }

    public void deletarItemVenda(Long id){
        itemVendaRepository.delete(buscarItemVenda(id));
    }

    public Optional<ItemVenda> buscarPorId(Long id) {
        return itemVendaRepository.findById(id);
    }

}
