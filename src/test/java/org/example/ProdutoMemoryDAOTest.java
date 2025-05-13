package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoMemoryDAOTest {

    private ProdutoMemoryDAO dao;

    @BeforeEach
    void setUp() {
        dao = new ProdutoMemoryDAO(); // sempre cria uma DAO nova antes de cada teste
    }

    @Test
    void testInsereEBusca() {
        Produto p = new Produto(1, "Mouse", new BigDecimal("49.90"));
        dao.insere(p);

        Produto resultado = dao.buscaPorId(1);

        assertNotNull(resultado); // verifica se o produto foi encontrado
        assertEquals("Mouse", resultado.getProduto()); // verifica o nome
        assertEquals(new BigDecimal("49.90"), resultado.getPreco()); // verifica o preço
    }

    @Test
    void testInserirProduto() {
        Produto produto = new Produto(1, "Produto Teste", new BigDecimal("10.00"));
        dao.insere(produto);
        Produto resultado = dao.buscaPorId(1);
        assertNotNull(resultado);
        assertEquals("Produto Teste", resultado.getProduto());
        assertEquals(new BigDecimal("10.00"), resultado.getPreco());
    }

    @Test
    void testBuscaPorIdProdutoExistente() {
        Produto produto = new Produto(2, "Caneta", new BigDecimal("2.50"));
        dao.insere(produto);
        Produto resultado = dao.buscaPorId(2);
        assertNotNull(resultado);
        assertEquals("Caneta", resultado.getProduto());
    }

    @Test
    void testBuscaPorIdProdutoInexistente() {
        Produto resultado = dao.buscaPorId(999); // ID que não existe
        assertNull(resultado);
    }

    @Test
    void testAlteraProduto() {
        Produto produtoOriginal = new Produto(3, "Lápis", new BigDecimal("1.00"));
        dao.insere(produtoOriginal);

        Produto produtoAlterado = new Produto(3, "Lápis Preto", new BigDecimal("1.50"));
        dao.altera(produtoAlterado);

        Produto resultado = dao.buscaPorId(3);
        assertNotNull(resultado);
        assertEquals("Lápis Preto", resultado.getProduto());
        assertEquals(new BigDecimal("1.50"), resultado.getPreco());
    }

    @Test
    void testExcluiProduto() {
        Produto produto = new Produto(4, "Borracha", new BigDecimal("0.75"));
        dao.insere(produto);

        dao.exclui(4);

        Produto resultado = dao.buscaPorId(4);
        assertNull(resultado);
    }

    @Test
    void testListaProdutos() {
        Produto p1 = new Produto(5, "Lápis", new BigDecimal("1.00"));
        Produto p2 = new Produto(6, "Caderno", new BigDecimal("12.00"));

        dao.insere(p1);
        dao.insere(p2);

        Collection<Produto> lista = dao.lista();

        assertEquals(2, lista.size());
        assertTrue(lista.contains(p1));
        assertTrue(lista.contains(p2));
    }
}