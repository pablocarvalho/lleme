package uff.ic.lleme.tic10002.aulas.s20181.listas;

import uff.ic.lleme.tic10002.aulas.s20181.Objeto;

public interface Lista {

    public Objeto buscar(int chave);

    public Objeto obter(int pos);

    public void incluir(Objeto objeto);

    public void excluir(int chave);

}
