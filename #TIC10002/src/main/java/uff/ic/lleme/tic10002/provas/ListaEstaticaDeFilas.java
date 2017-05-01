package uff.ic.lleme.tic10002.provas;

public class ListaEstaticaDeFilas {

    private FilaEstaticaDeInt[] elementos = null;
    private int tamanho = 0;

    private ListaEstaticaDeFilas() {
    }

    public ListaEstaticaDeFilas(int tamanho) {
        this.elementos = new FilaEstaticaDeInt[tamanho];
    }

    public int tamanho() {
        return tamanho;
    }

    public FilaEstaticaDeInt incluir(FilaEstaticaDeInt elemento) {
        if (tamanho < elementos.length)
            return elementos[tamanho++] = elemento;
        else
            return null;
    }

    public FilaEstaticaDeInt excluir(int pos) {
        FilaEstaticaDeInt resultado = null;
        if (pos < tamanho)
            resultado = elementos[pos];
        for (int i = pos; i < tamanho; i++)
            if (pos + 1 < elementos.length - 1)
                elementos[pos] = elementos[pos + 1];
            else
                elementos[pos] = null;
        tamanho--;
        return resultado;
    }

    private FilaEstaticaDeInt obter(int pos) {
        if (pos >= 0 && pos < tamanho)
            return elementos[pos];
        else
            return null;
    }

    public ListaEstaticaDeFilas uniao(ListaEstaticaDeFilas lista) {
        ListaEstaticaDeFilas resultado = new ListaEstaticaDeFilas(this.tamanho + lista.tamanho());
        for (int j = 0; j < elementos.length; j++)
            resultado.incluir(this.elementos[j]);
        for (int j = 0; j < lista.tamanho(); j++)
            resultado.incluir(lista.obter(j));
        return resultado;
    }

}
