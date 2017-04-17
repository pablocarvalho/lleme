package uff.ic.lleme.ttic10002.lista;

import uff.ic.lleme.ttic10002.Empregado;

public class No {

    public Object conteudo = null;
    public No proximo = null;

    public No(Empregado emp) {
        conteudo = emp;
    }

}
