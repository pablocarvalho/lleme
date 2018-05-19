package uff.ic.lleme.tic10002.aulas._old.s20172.Lista;

import uff.ic.lleme.tic10002.aulas._old.s20172.oo.Empregado;

public interface ListaDeEmpregado {

    public boolean inserir(Empregado e);

    public Empregado excluir(int matricula);

    public Empregado buscar(int matricula);

    public Empregado buscar(String nome);
}
