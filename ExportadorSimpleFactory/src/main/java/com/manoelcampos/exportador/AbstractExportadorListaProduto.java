package com.manoelcampos.exportador;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe abstrata que fornece uma implementação base para as subclasses
 * que definem formatos específicos de exportação de dados.
 *
 * @author Manoel Campos da Silva Filho
 */
public abstract class AbstractExportadorListaProduto implements ExportadorListaProduto {

    /**
     * Colunas a serem exibidas na tabela gerada no processo de exportação.
     */
    protected static final List<String> TITULOS_COLUNAS = List.of("ID", "Descrição", "Marca", "Modelo", "Estoque");

    @Override
    public final String exportar(List<Produto> listaProdutos) {
        var sb = new StringBuilder()
                        .append(abrirTabela())
                        .append(abrirLinhaTitulos())
                        .append(gerarColunas())
                        .append(fecharLinhaTitulos())
                        .append(gerarLinhasDados(listaProdutos))
                        .append(fecharTabela());

        return sb.toString();
    }

    private String gerarLinhasDados(List<Produto> listaProdutos) {
        var sb = new StringBuilder();
        for (Produto produto : listaProdutos) {
            sb.append(abrirLinha())
                .append(abrirColuna(String.valueOf(produto.getId())))
                .append(abrirColuna(produto.getDescricao()))
                .append(fecharColuna())
                .append(abrirColuna(produto.getMarca()))
                .append(fecharColuna())
                .append(abrirColuna(produto.getModelo()))
                .append(fecharColuna())
                .append(abrirColuna(String.valueOf(produto.getEstoque())))
                .append(fecharColuna())
                .append(fecharLinha());
        }
        return sb.toString();
    }

    private String gerarColunas() {
        return TITULOS_COLUNAS.stream()
              .map(col -> abrirColuna(col) + fecharColuna())
              .collect(Collectors.joining());
    }
}
