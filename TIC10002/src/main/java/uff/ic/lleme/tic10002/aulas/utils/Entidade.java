package uff.ic.lleme.tic10002.aulas.utils;

public abstract class Entidade<K extends Comparable<K>, E extends Entidade> implements Comparable<E> {

    public abstract K chave();
}
