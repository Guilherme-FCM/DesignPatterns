package com.example.boletobancario.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Boleto {
    private int id;
    String codBanco;
    LocalDate dataVencimento;
    LocalDateTime dataPagamento;
    String cpfCliente;
    double valor;
    double multa;
    double juros;
    String agencia;
    String contaBancaria;
}
