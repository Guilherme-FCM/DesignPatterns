package com.example.boletobancario;

import com.example.boletobancario.entidades.Boleto;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Function;

public class ProcessarBoletos {
    private Function<String[], Boleto> processarLinha;

    public ProcessarBoletos(Function<String[], Boleto> processarLinha) {
        this.processarLinha = processarLinha;
    }

    public void processar(URI nomeArquivo) {
        var boletos = new ArrayList<Boleto>();
        try {
            var lista = Files.readAllLines(Paths.get(nomeArquivo));
            for (String linha : lista) {
                var vetor = linha.split(";");
                var boleto = processarLinha.apply(vetor);
                boletos.add(boleto);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        boletos.forEach(System.out::print);
    }

    public void setProcessarLinha(Function<String[], Boleto> processarLinha) {
        this.processarLinha = processarLinha;
    }
}
