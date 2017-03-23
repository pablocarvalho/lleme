package uff.ic.lleme.ttic10002;

public class ListaEstaticaNaoOrdenada<T extends Entidade> {

    private Entidade[] lista = new Entidade[1000];
    private int tamanho = 0;

    public void incluir(T elem) {

    }

    public int tamanho() {
        return tamanho;
    }

    public T excluir(int chave) {
        lista[0].chave();
        return null;
    }

    public T buscar(int chave) {
        return null;
    }
}
