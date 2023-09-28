package main.example.exportador;

import java.lang.reflect.Field;
import java.util.function.Function;

public class ColunaHtml<T> extends AbstractColuna<T> {
    protected ColunaHtml(Field campo) {
        super(campo);
    }

    public ColunaHtml(Function<T, String> funcaoValorColuna, String titulo) {
        super(funcaoValorColuna, titulo);
    }

    @Override
    public String abrir()  {
        return "<td>";
    }

    @Override
    public String fechar()  {
        return "</td>";
    }
}
