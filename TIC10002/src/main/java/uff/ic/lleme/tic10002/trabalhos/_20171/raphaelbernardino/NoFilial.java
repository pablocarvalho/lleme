package uff.ic.lleme.tic10002.trabalhos._20171.raphaelbernardino;

import uff.ic.lleme.tic10002.trabalhos._20171.raphaelbernardino.Filial;

/**
 * @author bernardino
 */
public class NoFilial
{

    private final Filial filial;
    private NoFilial esq = null;
    private NoFilial dir = null;
    private int altura;

    public NoFilial(Filial f)
    {
        filial = f;
    }

    public Filial getFilial()
    {
        return this.filial;
    }

    public NoFilial getEsq()
    {
        return esq;
    }

    public NoFilial getDir()
    {
        return dir;
    }

    public int getAltura()
    {
        return altura;
    }

    public void setEsq(NoFilial esq)
    {
        this.esq = esq;
    }

    public void setDir(NoFilial dir)
    {
        this.dir = dir;
    }

    public void setAltura(int altura)
    {
        this.altura = altura;
    }
}
