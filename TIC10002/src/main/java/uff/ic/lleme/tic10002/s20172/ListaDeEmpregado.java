package uff.ic.lleme.tic10002.s20172;

public interface ListaDeEmpregado {

    public boolean inserir(Empregado e);

    public Empregado excluir(int matricula);

    public Empregado buscar(int matricula);

    public Empregado buscar(String nome);
}
