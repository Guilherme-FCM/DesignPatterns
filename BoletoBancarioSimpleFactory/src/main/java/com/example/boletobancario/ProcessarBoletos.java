package com.example.boletobancario;

import com.example.boletobancario.entidades.Boleto;
import com.example.boletobancario.factories.LeituraRetornoFactory;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Function;

public class ProcessarBoletos {
    private Function<String[], Boleto> processarLinha;
    private URI caminhoArquivo;

    public ProcessarBoletos(String caminhoArquivo) throws URISyntaxException {
        setBehaviorByCaminho(caminhoArquivo);
    }

    public void processar() {
        var boletos = new ArrayList<Boleto>();
        try {
            var lista = Files.readAllLines(Paths.get(caminhoArquivo));
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

    public void setBehaviorByCaminho(String caminhoArquivo) throws URISyntaxException {
        this.processarLinha = LeituraRetornoFactory.getBehavior(caminhoArquivo);
        this.caminhoArquivo = new URI(caminhoArquivo);
    }
}
