package com.example.singleton.app;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relatorio")
@AllArgsConstructor
public class RelatorioController {
    private Config config;

    @GetMapping("/get")
    public Config getConfig() {
        return config;
    }

    @GetMapping("/put")
    public Config updateConfig() {
        config.setTipoGrafico("pizza");
        return config;
    }
}
