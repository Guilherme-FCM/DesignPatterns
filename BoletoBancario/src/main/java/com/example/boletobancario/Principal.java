package com.example.boletobancario;

import com.example.boletobancario.comportamentos.LeituraRetornoBancoBrasil;

import java.net.URI;
import java.net.URISyntaxException;

public class Principal {
    public static void main(String[] args) throws URISyntaxException {
        var leituraRetorno = new LeituraRetornoBancoBrasil();
        var processador = new ProcessarBoletos(leituraRetorno);
        String caminho = "file:///home/aluno05/IdeaProjects/BoletoBancario/banco-brasil.csv";
        processador.processar(new URI(caminho));
    }
}
