package uff.ic.lleme.tic10002.provas;

public class ListaEstatica {

    private int[] elementos = null;
    private int tamanho = 0;

    private ListaEstatica() {
    }

    public ListaEstatica(int[] elementos) {
        this.elementos = elementos;
        this.tamanho = elementos.length;
    }

    public ListaEstatica(int tamanho) {
        this.elementos = new int[tamanho];
    }

    public int tamanho() {
        return tamanho;
    }

    public Integer incluir(int elemento) {
        if (tamanho < elementos.length)
            return elementos[tamanho++] = elemento;
        else
            return null;
    }

    public Integer excluir(int pos) {
        Integer resultado = null;
        if (pos < tamanho)
            resultado = elementos[pos];
        for (int i = pos; i < tamanho; i++)
            if (pos + 1 < elementos.length - 1)
                elementos[pos] = elementos[pos + 1];
            else
                elementos[pos] = 0;
        tamanho--;
        return resultado;
    }

    private Integer obter(int pos) {
        if (pos >= 0 && pos < tamanho)
            return elementos[pos];
        else
            return null;
    }

    public ListaEstatica uniao(ListaEstatica lista) {
        ListaEstatica resultado = new ListaEstatica(this.tamanho + lista.tamanho());
        for (int j = 0; j < elementos.length; j++)
            resultado.incluir(this.elementos[j]);
        for (int j = 0; j < lista.tamanho(); j++)
            resultado.incluir(lista.obter(j));
        return resultado;
    }

}
