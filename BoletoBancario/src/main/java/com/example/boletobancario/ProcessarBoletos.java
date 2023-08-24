package com.example.boletobancario;

import com.example.boletobancario.entidades.Boleto;
import com.example.boletobancario.interfaces.LeituraRetorno;

import java.awt.*;
import java.net.URI;
import java.util.List;
import java.util.function.Function;

public class ProcessarBoletos {
    private Function<URI, List<Boleto>> leituraRetorno;

    public void processar(URI nomeArquivo) {
        var boletos = leituraRetorno.apply(nomeArquivo);
        boletos.forEach(System.out::print);
    }

    public ProcessarBoletos(Function<URI, List<Boleto>> leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void setLeituraRetorno(Function<URI, List<Boleto>> leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
