package main.example.exportador;

import java.lang.reflect.Field;
import java.util.function.Function;

public class ColunaMarkdown<T> extends AbstractColuna<T> {
    public static final String SEPARADOR = "|";

    protected ColunaMarkdown(Field campo) {
        super(campo);
    }

    public ColunaMarkdown(Function<T, String> funcaoValorColuna, String titulo) {
        super(funcaoValorColuna, titulo);
    }

    @Override
    public String abrir() {
        return "";
    }

    @Override
    public String fechar() {
        return " " + SEPARADOR;
    }

}
