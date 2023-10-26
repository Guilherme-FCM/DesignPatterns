package com.example.cepservices.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Endereco {
    @JsonAlias("code")
    private String cep;

    @JsonAlias({"address", "endereco"})
    private String logradouro;

    @JsonAlias("district")
    private String bairro;

    @JsonAlias({"city", "cidade"})
    private String localidade;

    @JsonAlias({"state", "estado"})
    private String uf;

    private String complemento;
    private String ibge;
}
