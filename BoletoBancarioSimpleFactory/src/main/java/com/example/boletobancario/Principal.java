package com.example.boletobancario;

import java.net.URISyntaxException;

public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        String caminhoBancoBrasil = "file:///home/guilherme/Projects/DesignPatterns/BoletoBancarioTemplateMethod/banco-brasil.csv";
        String caminhoBradesco = "file:///home/guilherme/Projects/DesignPatterns/BoletoBancarioTemplateMethod/bradesco.csv";

        System.out.println("--- BANCO DO BRASIL ---");
        var processadorBoletos = new ProcessarBoletos(caminhoBancoBrasil);
        processadorBoletos.processar();


        System.out.println("\n--- BRADESCO ---");
        processadorBoletos.setBehaviorByCaminho(caminhoBradesco);
        processadorBoletos.processar();
    }
}
