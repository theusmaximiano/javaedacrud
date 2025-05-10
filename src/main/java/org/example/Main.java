package org.example;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static ProdutoDAO dao = new ProdutoMemoryDAO();

    public static void main(String[] args) {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\nCadastro de produtos");
            System.out.println("Digite a opção desejada");
            System.out.println("1 - Inserir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Pesquisar");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            opcao = s.nextInt();

            switch (opcao) {
                case 1 -> insere();
                case 2 -> altera();
                case 3 -> pesquisa();
                case 4 -> exclui();
                case 5 -> lista();
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        }
        s.close();
    }

    private static void insere() {
        System.out.println("Digite o id:");
        Integer id = s.nextInt();
        s.nextLine(); // limpar buffer

        System.out.println("Digite o nome do produto:");
        String produto = s.nextLine();

        System.out.println("Digite o preço:");
        BigDecimal preco = new BigDecimal(s.next());

        Produto p = new Produto(id, produto, preco);
        dao.insere(p);
        System.out.println("Produto inserido com sucesso.");
    }

    private static void altera() {
        System.out.println("Digite o id do produto a alterar:");
        Integer id = s.nextInt();
        s.nextLine();

        Produto existente = dao.buscaPorId(id);
        if (existente == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.println("Digite o novo nome do produto:");
        String novoNome = s.nextLine();

        System.out.println("Digite o novo preço:");
        BigDecimal novoPreco = new BigDecimal(s.next());

        Produto novoProduto = new Produto(id, novoNome, novoPreco);
        dao.altera(novoProduto);
        System.out.println("Produto alterado com sucesso.");
    }

    private static void pesquisa() {
        System.out.println("Digite o id do produto a pesquisar:");
        Integer id = s.nextInt();

        Produto p = dao.buscaPorId(id);
        if (p != null) {
            System.out.println("Produto encontrado:");
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getProduto());
            System.out.println("Preço: R$ " + p.getPreco());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void exclui() {
        System.out.println("Digite o id do produto a excluir:");
        Integer id = s.nextInt();

        Produto p = dao.buscaPorId(id);
        if (p != null) {
            dao.exclui(id);
            System.out.println("Produto excluído com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void lista() {
        System.out.println("Lista de produtos:");
        for (Produto p : dao.lista()) {
            System.out.println("ID: " + p.getId() +
                    ", Nome: " + p.getProduto() +
                    ", Preço: R$ " + p.getPreco());
        }
    }
}