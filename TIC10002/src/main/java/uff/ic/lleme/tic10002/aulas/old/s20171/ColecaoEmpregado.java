package uff.ic.lleme.tic10002.aulas.old.s20171;

import uff.ic.lleme.tic10002.utils.Empregado;
import java.io.InvalidObjectException;

public interface ColecaoEmpregado {

    public Empregado buscar(Integer cpf);

    public Empregado excluir(Integer cpf);

    public Empregado incluir(Empregado emp) throws InvalidObjectException;

}
