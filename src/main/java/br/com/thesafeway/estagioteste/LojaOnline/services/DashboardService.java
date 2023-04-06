package br.com.thesafeway.estagioteste.LojaOnline.services;

import br.com.thesafeway.estagioteste.LojaOnline.models.Produto;
import br.com.thesafeway.estagioteste.LojaOnline.models.Venda;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DashboardService {

    private final VendaService vendaService;
    private final ProdutoService produtoService;

    public DashboardService(VendaService vendaService, ProdutoService produtoService) {
        this.vendaService = vendaService;
        this.produtoService = produtoService;
    }


    public List<Venda> buscarTodasVendas() {
        return vendaService.buscarTodas();
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoService.buscarTodos();
    }

    public BigDecimal calcularTotalVendas() {
        List<Venda> vendas = buscarTodasVendas();
        BigDecimal total = BigDecimal.ZERO;
        for (Venda venda : vendas) {
            total = total.add(venda.getTotal());
        }
        return total;
    }

    public Long contarTotalProdutos() {
        return produtoService.count();
    }

    public Long contarTotalVendas() {
        return vendaService.count();
    }
}
