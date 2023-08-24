package com.example.boletobancario;

import com.example.boletobancario.comportamentos.LeituraRetornoBancoBrasil;
import com.example.boletobancario.comportamentos.LeituraRetornoBradesco;

import java.net.URI;
import java.net.URISyntaxException;

public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        System.out.println("--- BANCO DO BRASIL ---");
        var processador = new ProcessarBoletos(LeituraRetornoBancoBrasil::lerArquivo);

        String caminhoBancoBrasil = "file:///home/guilherme/Projects/DesignPatterns/BoletoBancario/banco-brasil.csv";
        processador.processar(new URI(caminhoBancoBrasil));

        System.out.println("\n--- BRADESCO ---");
        processador.setLeituraRetorno(LeituraRetornoBradesco::lerArquivo);

        String caminhoBradesco = "file:///home/guilherme/Projects/DesignPatterns/BoletoBancario/bradesco.csv";
        processador.processar(new URI(caminhoBradesco));
    }
}
