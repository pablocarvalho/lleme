package uff.ic.lleme.tic10002.lista;

import uff.ic.lleme.tic10002.Empregado;

public class No {

    public Object conteudo = null;
    public No proximo = null;

    public No(Empregado emp) {
        conteudo = emp;
    }

}
