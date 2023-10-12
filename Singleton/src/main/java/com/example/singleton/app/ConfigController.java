package com.example.singleton.app;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@AllArgsConstructor
public class ConfigController {
    // @Autowired // Não é mais necessario
    private Config config;

//    public ConfigController(Config config) {
//        this.config = config;
//    }

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
