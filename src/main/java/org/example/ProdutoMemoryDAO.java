package org.example;

import java.util.Collection;
import java.util.TreeSet;

public class ProdutoMemoryDAO implements ProdutoDAO {
    private Collection<Produto> produtos = new TreeSet<>();

    @Override
    public void insere(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public Produto buscaPorId(Integer id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null); // Retorna null caso não encontre
    }

    @Override
    public void altera(Produto produto) {
        exclui(produto.getId()); // Exclui o antigo produto
        produtos.add(produto); // Adiciona o novo produto alterado
    }

    @Override
    public void exclui(Integer id) {
        produtos.removeIf(p -> p.getId().equals(id)); // Remove produto pelo id
    }

    @Override
    public Collection<Produto> lista() {
        return produtos;
    }
}
