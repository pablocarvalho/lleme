package uff.ic.lleme.tic10002.lista;

import java.util.function.Predicate;
import uff.ic.lleme.tic10002.Entidade;

public interface Lista<K extends Comparable<K>, E extends Entidade<? super K, E>> {

    public int tamanho();

    public void incluir(E elem);

    public void alterar(int pos, E elem);

    public E excluir(K chave);

    public E buscar(K chave);

    public E buscar(int posicao);

    public Lista<K, E> buscar(Predicate<E> p);
}
