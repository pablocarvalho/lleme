package uff.ic.lleme.ttic10002.lista;

import java.util.function.Predicate;
import uff.ic.lleme.ttic10002.Entidade;

public interface ListaEstatica<K extends Comparable<K>, E extends Entidade<? super K, ?>> {

    public int tamanho();

    public void incluir(E elem);

    public E excluir(K chave);

    public E buscar(K chave);

    public E buscar(int posicao);

    public ListaEstaticaNaoOrdenada<K, E> buscar(Predicate<E> p);

}
