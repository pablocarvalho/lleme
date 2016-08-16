package provas.s20141.p120141;

import java.io.Serializable;

public interface Escalar<E> extends Serializable {

    public abstract E valor();

    public abstract Escalar<E> produto(Escalar<E> escalar);

    public abstract Escalar<E> quociente(Escalar<E> escalar);

    public abstract Escalar<E> soma(Escalar<E> escalar);

    public abstract Escalar<E> diferenca(Escalar<E> escalar);
}
