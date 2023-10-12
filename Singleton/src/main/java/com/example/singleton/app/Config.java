package com.example.singleton.app;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Config {
    private String formatoRelatorio = "pdf";
    private String tipoGrafico = "barras";

    private Config() {}

    private static final Config instance = new Config();
    public static Config getInstance() {
        return instance;
    }

//    private static Config instance;
//    public static Config getInstance() {
//        if (instance == null)
//            instance = new Config();
//
//        return instance;
//    }

    public String getFormatoRelatorio() {
        return formatoRelatorio;
    }

    public void setFormatoRelatorio(String formatoRelatorio) {
        this.formatoRelatorio = formatoRelatorio;
    }

    public String getTipoGrafico() {
        return tipoGrafico;
    }

    public void setTipoGrafico(String tipoGrafico) {
        this.tipoGrafico = tipoGrafico;
    }

    @Override
    public String toString() {
        return "Config{" +
                "formatoRelatorio='" + formatoRelatorio + '\'' +
                ", tipoGrafico='" + tipoGrafico + '\'' +
                '}';
    }
}
