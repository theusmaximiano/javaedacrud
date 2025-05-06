package org.example;

import java.util.Collection;
import java.util.TreeSet;

public class ProdutoMemoryDAO implements ProdutoDAO {
    private Collection<Produto> produtos = new TreeSet<>();

    @Override
    public void insere(Produto produto) {
        produtos.add(produto);
    }
}
