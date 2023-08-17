package com.example.boletobancario;

import com.example.boletobancario.interfaces.LeituraRetorno;

import java.net.URI;

public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;

    public void processar(URI nomeArquivo) {
        leituraRetorno.lerArquivo(nomeArquivo);
    }

    public ProcessarBoletos(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
