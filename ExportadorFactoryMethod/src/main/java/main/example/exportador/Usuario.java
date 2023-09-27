package main.example.exportador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
    private static int ultimoId = 0;

    private int id;
    private String nome;
    private String cpf;
    private String cidade;

    public Usuario(){
        this.id = ++ultimoId;
    }

    public Usuario(String nome, String cpf, String cidade) {
        this();
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSobrenome(){
        Pattern regexPattern = Pattern.compile(".+?\\s(.*)");
        Matcher matcher = regexPattern.matcher(nome);
        return matcher.matches() ? matcher.group(1) : "";
    }
}
