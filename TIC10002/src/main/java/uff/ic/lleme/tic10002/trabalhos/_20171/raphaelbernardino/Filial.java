package uff.ic.lleme.tic10002.trabalhos._20171.raphaelbernardino;

import java.util.*;

/**
 * @author bernardino
 */
public class Filial
{

    private final Integer codigo;
    private final MapaHash hm;

    public Filial(Integer c)
    {
        this.codigo = c;
        this.hm = new MapaHash();
    }

    public Integer getCodigo()
    {
        return codigo;
    }

    public MapaHash getHashMap()
    {
        return hm;
    }

    @Override
    public int hashCode()
    {
        return 42 * this.codigo.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Filial other = (Filial) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    public int compareTo(Filial e)
    {
        return this.getCodigo().compareTo(e.getCodigo());
    }

    @Override
    public String toString()
    {
        return "Filial" + this.codigo + "{" + hm.toString() + "}";
    }
}
