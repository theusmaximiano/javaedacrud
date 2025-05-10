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
        for (Produto p : produtos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void altera(Produto produto) {
        Produto produtoExistente = buscaPorId(produto.getId());
        if (produtoExistente != null) {
            produtoExistente.setProduto(produto.getProduto());
            produtoExistente.setPreco(produto.getPreco());
        }
    }

    @Override
    public Collection<Produto> lista() {
        return produtos;
    }
}
