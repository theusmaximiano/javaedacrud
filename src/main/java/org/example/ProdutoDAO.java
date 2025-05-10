package org.example;

import java.util.Collection;

public interface ProdutoDAO {

    void insere(Produto produto);

    Produto buscaPorId(Integer id);

    void altera(Produto produto);

    void exclui(Integer id);

    Collection<Produto> lista();
}