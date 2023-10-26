package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Produto produto = new ProdutoBuilder()
                .descricao("Televisao")
                .marca("LG")
                .createProduto();

        System.out.println(produto);
    }
}