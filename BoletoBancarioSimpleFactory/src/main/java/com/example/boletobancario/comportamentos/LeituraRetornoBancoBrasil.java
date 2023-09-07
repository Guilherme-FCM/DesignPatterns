package com.example.boletobancario.comportamentos;

import com.example.boletobancario.ProcessarBoletos;
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

public class LeituraRetornoBancoBrasil {

    public static Boleto processarLinha(String[] vetor) {
        var boleto = new Boleto();

        boleto.setId(Integer.parseInt(vetor[0]));
        boleto.setCodBanco(vetor[1]);

        var format = DateTimeFormatter.ofPattern("dd/MM/yyy");
        boleto.setDataVencimento(LocalDate.parse(vetor[2], format));
        boleto.setDataPagamento(LocalDate.parse(vetor[3], format).atTime(0,0));

        boleto.setCpfCliente(vetor[4]);
        boleto.setValor(Double.parseDouble(vetor[5]));
        boleto.setMulta(Double.parseDouble(vetor[6]));
        boleto.setJuros(Double.parseDouble(vetor[7]));

        return boleto;
    }
}
