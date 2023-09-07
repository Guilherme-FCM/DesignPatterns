package com.example.boletobancario.interfaces;

import com.example.boletobancario.entidades.Boleto;

import java.net.URI;
import java.util.List;

public interface LeituraRetorno {
    public List<Boleto> lerArquivo(URI nomeArquivo);
}
