package org.example;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static ProdutoDAO dao = new ProdutoMemoryDAO();
    public static void main(String[] args) {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("Cadastro de produtos");
            System.out.println("Digite a opção desejada");
            System.out.println("1 - Inserir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Pesquisar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            opcao = s.nextInt();
            switch (opcao) {
                case 1 -> insere();
                default -> System.out.println("Opcao invalida");
            }
        }
        s.close();
    }

    private static void insere() {
        System.out.println("Digite o id");
        Integer id = s.nextInt();

        System.out.println("Digite o produto");
        String produto = s.next();

        System.out.println("Digite o preco");
        String preco = s.next();

        Produto p = new Produto(id, produto, new BigDecimal(preco));
        dao.insere(p);
    }
}