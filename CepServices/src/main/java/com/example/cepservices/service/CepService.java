package com.example.cepservices.service;

import com.example.cepservices.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name="viacep")
public interface CepService {
    @GetMapping("/{cep}/json")
    Endereco getEndereco(@PathVariable String cep);
}
