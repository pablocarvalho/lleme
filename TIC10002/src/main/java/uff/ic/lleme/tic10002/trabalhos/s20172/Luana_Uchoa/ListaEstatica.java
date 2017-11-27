package uff.ic.lleme.tic10002.trabalhos.s20172.Luana_Uchoa;

public class ListaEstatica<T> {

    protected int tamanhoAtual = 0;
    protected int tamanhoMaximo = 0;
    protected Object[] lista;

    //... construtor.
    public ListaEstatica(int tamanhoMaximo) {
        if (tamanhoMaximo < 0)
            throw new IllegalArgumentException("Tamanho deve ser um número maior que 0 (zero).");

        this.tamanhoMaximo = tamanhoMaximo;
        this.lista = new Object[tamanhoMaximo];
    }

    public int tamanho() {
        return tamanhoAtual;
    }

    public boolean vazia() {
        return tamanho() == 0;
    }

    public boolean insere(T e) {
        if (tamanho() + 1 <= tamanhoMaximo) {
            ((Object[]) this.lista)[tamanhoAtual++] = e;
            return true;
        }
        return false;
    }

    public Object remove(int index) {
        Object elemento = null;
        if (index < tamanhoAtual) {
            elemento = ((Object[]) this.lista)[index];
            tamanhoAtual--;
        }
        return elemento;
    }

    public T get(int index) {
        Object elemento = null;
        if (index < tamanhoAtual)
            elemento = ((Object[]) this.lista)[index];
        return (T) elemento;
    }

    public T set(int index, T novoElemento) {
        Object elemento = null;
        if (index < tamanhoAtual)
            elemento = ((Object[]) this.lista)[index] = novoElemento;
        return (T) elemento;
    }

    public int posicao(T o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public T busca(T obj) {
        return null;
    }

}
