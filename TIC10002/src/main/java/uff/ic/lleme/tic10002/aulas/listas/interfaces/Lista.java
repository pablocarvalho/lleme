package uff.ic.lleme.tic10002.aulas.listas.interfaces;

import uff.ic.lleme.tic10002.aulas.utils.Conteudo;

public interface Lista {

    public Conteudo buscar(int chave);

    public Conteudo obter(int pos);

    public void incluir(Conteudo objeto);

    public void excluir(int chave);

}
