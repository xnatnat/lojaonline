package br.com.thesafeway.estagioteste.LojaOnline.services;

import br.com.thesafeway.estagioteste.LojaOnline.dtos.ProdutoDto;
import br.com.thesafeway.estagioteste.LojaOnline.dtos.UsuarioDto;
import br.com.thesafeway.estagioteste.LojaOnline.dtos.VendaDto;
import br.com.thesafeway.estagioteste.LojaOnline.models.Produto;
import br.com.thesafeway.estagioteste.LojaOnline.models.Usuario;
import br.com.thesafeway.estagioteste.LojaOnline.models.Venda;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BootstrapDataService {
    private final UsuarioService usuarioService;
    private final ProdutoService produtoService;
    private final VendaService vendaService;

    private final DashboardService dashboardService;

    public BootstrapDataService(UsuarioService usuarioService, ProdutoService produtoService, VendaService vendaService, DashboardService dashboardService) {
        this.usuarioService = usuarioService;
        this.produtoService = produtoService;
        this.vendaService = vendaService;
        this.dashboardService = dashboardService;
    }

    public void bootstrap() {
        // Cria alguns usuários
        Usuario usuario1 = usuarioService.salvarUsuario(new UsuarioDto(null, "Jonas", "44577844400", "jonas@gmail.com"));
        Usuario usuario2 = usuarioService.salvarUsuario(new UsuarioDto(null, "Maria", "55577788801", "maria@gmail.com"));

        // Cria alguns produtos
        Produto produto1 = produtoService.salvarProduto(new ProdutoDto(null, "Moletom Rosa", "Moletom Rosa", "Marca A", 100L, new BigDecimal(50)));
        Produto produto2 = produtoService.salvarProduto(new ProdutoDto(null, "Calça", "Calça Jeans", "Marca B", 100L, new BigDecimal(80)));
        Produto produto3 = produtoService.salvarProduto(new ProdutoDto(null, "Tênis", "Tênis Preto", "Marca C", 100L, new BigDecimal(100)));

        // Cria uma venda
        Venda venda = vendaService.salvarVenda(new VendaDto(usuario1));

        // Adiciona alguns itens à venda
        vendaService.adicionarItem(venda, produto1, 2L);
        vendaService.adicionarItem(venda, produto2, 5L);

        // Cria outra venda
        Venda venda2 = vendaService.salvarVenda(new VendaDto(usuario2));

        // Adiciona alguns itens à venda
        vendaService.adicionarItem(venda2, produto3, 3L);

        // Cria outra venda
        Venda venda3 = vendaService.salvarVenda(new VendaDto(usuario1));

        // Adiciona alguns itens à venda
        vendaService.adicionarItem(venda3, produto3, 5L);
        vendaService.adicionarItem(venda3, produto1, 4L);

        System.out.println("Resumo de vendas");
        System.out.println("Quantidade total de vendas");
        System.out.println(dashboardService.contarTotalVendas());
        System.out.println("Preço total de vendas");
        System.out.println(dashboardService.calcularTotalVendas());

        System.out.println("Resumo de Produtos");
        System.out.println("Quantidade total de produtos registrados");
        System.out.println(dashboardService.contarTotalProdutos());
    }
}
