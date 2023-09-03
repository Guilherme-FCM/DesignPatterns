package com.example.boletobancario;

import com.example.boletobancario.entidades.Boleto;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class ProcessarBoletos {

    public void processar(URI nomeArquivo) {
        var boletos = new ArrayList<Boleto>();
        try {
            var lista = Files.readAllLines(Paths.get(nomeArquivo));
            for (String linha : lista) {
                var vetor = linha.split(";");
                var boleto = processarLinha(vetor);
                boletos.add(boleto);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        boletos.forEach(System.out::print);
    }

    protected abstract Boleto processarLinha(String[] vetor);
}
