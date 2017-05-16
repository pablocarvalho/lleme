package uff.ic.lleme.tic10002;

import java.io.InvalidObjectException;

public interface ColecaoEmpregado {

    public Empregado buscar(String cpf);

    public Empregado excluir(String cpf);

    public Empregado incluir(Empregado emp) throws InvalidObjectException;

}
