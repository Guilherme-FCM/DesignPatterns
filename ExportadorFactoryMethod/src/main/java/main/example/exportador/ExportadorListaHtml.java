package main.example.exportador;

import java.lang.reflect.Field;
import java.util.List;

public class ExportadorListaHtml<T> extends AbstractExportadorLista<T> {
    public ExportadorListaHtml(List<T> lista) {
        super(lista);
    }

    @Override
    public String abrirTabela() {
        return "<table>\n";
    }

    @Override
    public String fecharTabela() {
        return "</table>\n";
    }

    @Override
    public String abrirLinha() {
        return "  <tr>";
    }

    @Override
    public String fecharLinha() {
        return "</tr>\n";
    }

    @Override
    public String fecharLinhaTitulos() {
        return "";
    }

    @Override
    public Coluna newColuna(Field campo) {
        return new ColunaHtml<>(campo);
    }

}
