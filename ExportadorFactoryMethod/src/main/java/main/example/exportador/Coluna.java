package main.example.exportador;

public interface Coluna<T> {
    String getTitulo();
    void setTitulo(String titulo);
    String abrir();
    String fechar();
    String exportarCabecalho();
    String exportarDado(T objeto);
}
