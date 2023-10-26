package org.example;

public class ProdutoBuilder {
    private Long id;
    private String titulo;
    private String descricao;
    private String marca;
    private String modelo;
    private int estoque;
    private double preco;
    private String url;

    public ProdutoBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ProdutoBuilder titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public ProdutoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public ProdutoBuilder marca(String marca) {
        this.marca = marca;
        return this;
    }

    public ProdutoBuilder modelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public ProdutoBuilder estoque(int estoque) {
        this.estoque = estoque;
        return this;
    }

    public ProdutoBuilder preco(double preco) {
        this.preco = preco;
        return this;
    }

    public ProdutoBuilder url(String url) {
        this.url = url;
        return this;
    }

    public Produto createProduto() {
        return new Produto(id, titulo, descricao, marca, modelo, estoque, preco, url);
    }
}