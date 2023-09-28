package main.example.exportador;

import java.lang.reflect.Field;
import java.util.function.Function;

public abstract class AbstractColuna<T> implements Coluna<T> {
    private Field campo;
    private String titulo;

    private Function<T, String> funcaoValorColuna;

    protected AbstractColuna(Field campo) {
        this(campo.getName());
        this.campo = campo;
        this.campo.setAccessible(true);
    }

    public AbstractColuna(Function<T, String> funcaoValorColuna, String titulo) {
        this(titulo);
        this.funcaoValorColuna = funcaoValorColuna;
    }

    private AbstractColuna(String titulo) {
        setTitulo(titulo);
    }

    private String getValor(T objeto) {
        if(funcaoValorColuna != null){
            return funcaoValorColuna.apply(objeto);
        }

        try {
            final Object valorCampo = campo.get(objeto);
            return valorCampo == null ? "" : String.valueOf(valorCampo);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public final void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public final String exportarCabecalho() {
        return abrir() + getTitulo() + fechar();
    }

    @Override
    public final String exportarDado(T objeto) {
        return abrir() + getValor(objeto) + fechar();
    }
}
