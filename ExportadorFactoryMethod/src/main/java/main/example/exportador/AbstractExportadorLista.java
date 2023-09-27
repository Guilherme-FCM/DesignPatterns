package main.example.exportador;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractExportadorLista<T> implements ExportadorLista<T> {
    private List<T> lista;
    private List<Coluna> colunas;

    public AbstractExportadorLista(final List<T> lista) {
        Objects.requireNonNull(lista, "A lista de objetos não pode ser nula");
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("A lista fornecida está vazia");
        }

        this.lista = lista;
        this.colunas = geraListaColunas();
    }

    @Override
    public String exportar() {
        final StringBuilder sb = new StringBuilder();
        sb.append(abrirTabela());
        exportarTitulosColunas(sb);
        exportarLinhas(sb);

        sb.append(fecharTabela());
        return sb.toString();
    }

    private List<Coluna> geraListaColunas() {
        final T objeto = lista.get(0);

        final List<Coluna> colunas = new ArrayList<>();

        // Obtém o nome dos campos (fields) declarados diretamente na classe do objeto.
        final Field[] campos = objeto.getClass().getDeclaredFields();
        for (Field campo : campos) {
            // Atributos estáticos não serão incluídos na tabela gerada
            if (!Modifier.isStatic(campo.getModifiers())) {
                colunas.add(newColuna(campo));
            }
        }

        return colunas;
    }

    private void exportarTitulosColunas(StringBuilder sb) {
        sb.append(abrirLinha());
        for (Coluna coluna : colunas) {
            sb.append(coluna.exportarCabecalho());
        }
        sb.append(fecharLinha())
                .append(fecharLinhaTitulos());
    }

    private void exportarLinhas(StringBuilder sb) {
        for (Object objeto : lista) {
            exportarDadosColunas(sb, objeto);
        }
    }

    private void exportarDadosColunas(StringBuilder sb, Object objeto) {
        sb.append(abrirLinha());
        for (Coluna coluna : colunas) {
            sb.append(coluna.exportarDado(objeto));
        }
        sb.append(fecharLinha());
    }

    public List<Coluna> getColunas() {
        return colunas;
    }

    @Override
    public void addColuna(Coluna<T> coluna) {
        colunas.add(coluna);
    }

    protected abstract Coluna newColuna(Field campo);
}
