package uff.ic.lleme.tic10002.aulas.s20171.lista;

import uff.ic.lleme.tic10002.aulas.s20171.Entidade;

public abstract interface ListaNaoOrdenada<K extends Comparable<K>, E extends Entidade<? super K, E>> extends Lista<K, E> {

    public abstract void trocar(int i, int j);

    public abstract void merge(int p, int q, int r);
}
