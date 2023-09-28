package main.example.exportador;

import java.lang.reflect.Field;
import java.util.List;

public class ExportadorListaMarkdown<T> extends AbstractExportadorLista<T> {
    private static final String SEPARADOR_LN = "-";
    public ExportadorListaMarkdown(List<T> lista) {
        super(lista);
    }

    @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "\n";
    }

    @Override
    public String abrirLinha() {
        return "";
    }

    @Override
    public String fecharLinha() {
        return "\n";
    }

    @Override
    public String fecharLinhaTitulos() {
        StringBuilder sb = new StringBuilder();
        for (Coluna coluna : getColunas()) {
            String linha = stringRepeat(SEPARADOR_LN, coluna.getTitulo().length());
            sb.append(linha).append(ColunaMarkdown.SEPARADOR);
        }

        sb.append("\n");
        return sb.toString();
    }

    private String stringRepeat(String s, int repeticoes){
        return String.format("%0" + repeticoes + "d", 0).replace("0", s);
    }

    @Override
    public Coluna newColuna(Field campo) {
        return new ColunaMarkdown<>(campo);
    }

}
