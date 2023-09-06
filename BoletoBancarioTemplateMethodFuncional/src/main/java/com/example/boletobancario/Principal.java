package com.example.boletobancario;

import com.example.boletobancario.comportamentos.LeituraRetornoBancoBrasil;
import com.example.boletobancario.comportamentos.LeituraRetornoBradesco;

import java.net.URI;
import java.net.URISyntaxException;

public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        System.out.println("--- BANCO DO BRASIL ---");
        String caminhoBancoBrasil = "file:///home/guilherme/Projects/DesignPatterns/BoletoBancarioTemplateMethod/banco-brasil.csv";

        var processadorBoletos = new ProcessarBoletos(LeituraRetornoBancoBrasil::processarLinha);
        processadorBoletos.processar(new URI(caminhoBancoBrasil));

        System.out.println("\n--- BRADESCO ---");
        String caminhoBradesco = "file:///home/guilherme/Projects/DesignPatterns/BoletoBancarioTemplateMethod/bradesco.csv";

        processadorBoletos.setProcessarLinha(LeituraRetornoBradesco::processarLinha);
        processadorBoletos.processar(new URI(caminhoBradesco));
    }
}
