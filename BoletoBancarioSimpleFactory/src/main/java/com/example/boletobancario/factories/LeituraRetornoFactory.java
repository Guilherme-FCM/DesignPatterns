package com.example.boletobancario.factories;

import com.example.boletobancario.comportamentos.LeituraRetornoBancoBrasil;
import com.example.boletobancario.comportamentos.LeituraRetornoBradesco;
import com.example.boletobancario.entidades.Boleto;

import java.net.URI;
import java.util.function.Function;

public class LeituraRetornoFactory {
    public static Function<String[], Boleto> getBehavior(String caminhoArquivo) {
        if (caminhoArquivo.contains("banco-brasil.csv")) {
            return LeituraRetornoBancoBrasil::processarLinha;
        } else {
            return LeituraRetornoBradesco::processarLinha;
        }
    }
}
