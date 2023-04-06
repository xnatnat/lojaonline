package br.com.thesafeway.estagioteste.LojaOnline.services;

import br.com.thesafeway.estagioteste.LojaOnline.dtos.ProdutoDto;
import br.com.thesafeway.estagioteste.LojaOnline.models.Produto;
import br.com.thesafeway.estagioteste.LojaOnline.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvarProduto(ProdutoDto produtoDto) {
        var produto = new Produto(
                produtoDto.getNome(),
                produtoDto.getDescricao(),
                produtoDto.getMarca(),
                produtoDto.getQuantidade(),
                produtoDto.getPreco(),
                new HashSet<>()
        );
        return produtoRepository.save(produto);
    }

    public Produto buscarProduto(Long id){
        return buscarPorId(id).orElseThrow();
    }

    public List<Produto> buscarTodos(){ return produtoRepository.findAll();}
    public Produto editarProduto(ProdutoDto produtoDto){
        var produtoData = buscarProduto(produtoDto.getId());
        produtoData.setNome(produtoDto.getNome());
        produtoData.setDescricao(produtoDto.getDescricao());
        produtoData.setMarca(produtoDto.getMarca());
        produtoData.setQuantidade(produtoDto.getQuantidade());
        produtoData.setPreco(produtoDto.getPreco());
        return produtoRepository.save(produtoData);
    }

    public void deletarProduto(Long id){
        produtoRepository.delete(buscarProduto(id));
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }


    public Long count() {
        return produtoRepository.count();
    }
}
