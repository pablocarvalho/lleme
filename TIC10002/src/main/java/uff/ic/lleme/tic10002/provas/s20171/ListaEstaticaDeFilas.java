package uff.ic.lleme.tic10002.provas.s20171;

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

}
