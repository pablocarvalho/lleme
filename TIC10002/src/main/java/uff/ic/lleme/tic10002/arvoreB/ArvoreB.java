package uff.ic.lleme.tic10002.arvoreB;

import uff.ic.lleme.tic10002.Empregado;

public class ArvoreB {

    private ListaEntrada raiz = null;

    public void inserir(Empregado empregado) throws Exception {
        if (raiz == null) {
            raiz = new ListaEntrada();
            raiz.inserir(empregado);
        } else {
            Insercao meio = raiz.inserir(empregado);
            raiz = new ListaEntrada();

        }
    }
}
