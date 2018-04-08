package uff.ic.lleme.tic10002.aulas.s20181.listas;

import uff.ic.lleme.tic10002.aulas.s20181.Objeto;

public interface Lista {

    public Objeto busca(int chave);

    public Objeto[] busca(String nome);

    public void inserir(Objeto objeto);

    public void excluir(int chave);
}
