package com.example.boletobancario.comportamentos;

import com.example.boletobancario.entidades.Boleto;
import com.example.boletobancario.interfaces.LeituraRetorno;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBradesco {
    public static List<Boleto> lerArquivo(URI nomeArquivo) {
        var boletos = new ArrayList<Boleto>();
        try {
            var lista = Files.readAllLines(Paths.get(nomeArquivo));
            for (String linha : lista) {
                var vetor = linha.split(";");
                var boleto = new Boleto();

                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);

                var dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyy");
                var dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
                boleto.setDataVencimento(LocalDate.parse(vetor[4], dateFormat));
                boleto.setDataPagamento(LocalDateTime.parse(vetor[5], dateTimeFormat));

                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[9]));

                boletos.add(boleto);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return boletos;
    }
}
