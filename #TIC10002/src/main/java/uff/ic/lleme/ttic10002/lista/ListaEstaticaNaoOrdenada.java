package uff.ic.lleme.ttic10002.lista;

import java.util.function.Predicate;
import uff.ic.lleme.ttic10002.Entidade;

public class ListaEstaticaNaoOrdenada<K, E extends Entidade<? super K, ?>> {

    private Entidade[] lista = new Entidade[1000];
    private int tamanho = 0;

    public void incluir(E elem) {

    }

    public int tamanho() {
        return 0;
    }

    public E excluir(K chave) {
        E resultado = null;

        return resultado;
    }

    public E buscar(K chave) {

        return null;
    }

    public ListaEstaticaNaoOrdenada<K, E> buscar(Predicate<E> p) {
        ListaEstaticaNaoOrdenada<K, E> resultado = null;

        return resultado;
    }

}
