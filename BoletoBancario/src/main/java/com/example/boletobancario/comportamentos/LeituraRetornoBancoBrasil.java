package com.example.boletobancario.comportamentos;

import com.example.boletobancario.entidades.Boleto;
import com.example.boletobancario.interfaces.LeituraRetorno;

import java.net.URI;
import java.util.List;

public class LeituraRetornoBancoBrasil implements LeituraRetorno {
    @Override
    public List<Boleto> lerArquivo(URI nomeArquivo) {
        return null;
    }
}
