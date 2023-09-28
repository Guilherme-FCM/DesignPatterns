package main.example.exportador;

import java.util.List;

public interface ExportadorLista<T> {
    static <T> ExportadorLista<T> newInstance(final List<T> lista){
        return newInstance(lista, "html");
    }

    static <T> ExportadorLista<T> newInstance(final List<T> lista, String extensaoArquivoExportacao){
        switch (extensaoArquivoExportacao){
            case "html": return new ExportadorListaHtml<>(lista);
            case "md": return new ExportadorListaMarkdown<>(lista);
            default: throw new UnsupportedOperationException("Formato de arquivo não suportado: " + extensaoArquivoExportacao);
        }
    }

    String abrirTabela();
    String fecharTabela();
    String abrirLinha();
    String fecharLinha();
    String fecharLinhaTitulos();
    String exportar();
    void addColuna(Coluna<T> coluna);
}
