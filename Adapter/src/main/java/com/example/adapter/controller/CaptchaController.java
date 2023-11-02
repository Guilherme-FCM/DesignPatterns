package com.example.adapter.controller;

import com.example.adapter.utils.CaptchaGeneratorInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import java.io.IOException;

@RestController
@RequestMapping("/captcha")
@SessionScope
@AllArgsConstructor
public class CaptchaController {
    private final CaptchaGeneratorInterface generator;

    @GetMapping(value = "/gerar", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] gerar() throws IOException {
        return generator.generate();
    }

    @GetMapping(value = "/confirmar/{codigo}")
    public boolean confirmar(@PathVariable String codigo) {
        return generator.confirmCode(codigo);
    }
}
