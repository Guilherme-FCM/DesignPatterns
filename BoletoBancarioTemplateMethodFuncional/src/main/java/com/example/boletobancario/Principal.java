package com.example.boletobancario;

import com.example.boletobancario.comportamentos.LeituraRetornoBancoBrasil;
import com.example.boletobancario.comportamentos.LeituraRetornoBradesco;

import java.net.URI;
import java.net.URISyntaxException;

public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        System.out.println("--- BANCO DO BRASIL ---");
        String caminhoBancoBrasil = "file:///home/guilherme/Projects/DesignPatterns/BoletoBancarioTemplateMethod/banco-brasil.csv";
        var processadorBancoBrasil = new LeituraRetornoBancoBrasil();
        processadorBancoBrasil.processar(new URI(caminhoBancoBrasil));

        System.out.println("\n--- BRADESCO ---");
        String caminhoBradesco = "file:///home/guilherme/Projects/DesignPatterns/BoletoBancarioTemplateMethod/bradesco.csv";
        var processadorBradesco = new LeituraRetornoBradesco();
        processadorBradesco.processar(new URI(caminhoBradesco));
    }
}
