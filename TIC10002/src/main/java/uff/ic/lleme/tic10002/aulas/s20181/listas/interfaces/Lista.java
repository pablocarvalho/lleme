package uff.ic.lleme.tic10002.aulas.s20181.listas.interfaces;

import uff.ic.lleme.tic10002.aulas.s20181.Conteudo;

public interface Lista {

    public Conteudo buscar(int chave);

    public Conteudo obter(int pos);

    public void incluir(Conteudo objeto);

    public void excluir(int chave);

}
