package com.example.cepservices.controller;

import com.example.cepservices.model.Endereco;
import com.example.cepservices.service.CepService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cep")
@AllArgsConstructor
public class CepController {
    private final CepService service;

    @GetMapping("{cep}")
    public Endereco getEndereco(@PathVariable String cep) {
        return service.getEndereco(cep);
    }
}
