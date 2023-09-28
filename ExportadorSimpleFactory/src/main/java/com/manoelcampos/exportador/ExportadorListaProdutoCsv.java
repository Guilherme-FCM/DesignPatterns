package com.manoelcampos.exportador;

class ExportadorListaProdutoCsv extends AbstractExportadorListaProduto {
    @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "";
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
    public String abrirLinhaTitulos() {
        return abrirLinha();
    }

    @Override
    public String fecharLinhaTitulos() {
        return fecharLinha();
    }

    @Override
    public String abrirColuna(String valor) {
        return valor;
    }

    @Override
    public String fecharColuna() {
        return ";";
    }
}
