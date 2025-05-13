package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
}