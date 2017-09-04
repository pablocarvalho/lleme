package uff.ic.lleme.tic10002.aulas.s20171;

public abstract class Entidade<K extends Comparable<K>, E extends Entidade> implements Comparable<E> {

    public abstract K getChave();
}
