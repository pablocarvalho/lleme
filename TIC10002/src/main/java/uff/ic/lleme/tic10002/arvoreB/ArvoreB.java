package uff.ic.lleme.tic10002.arvoreB;

import uff.ic.lleme.tic10002.Empregado;

public class ArvoreB {

    private Pagina raiz = null;

    public void inserir(Empregado empregado) throws Exception {
        if (raiz == null) {
            raiz = new Pagina();
            raiz.inserir(empregado);
        } else {
            Divisao meio = raiz.inserir(empregado);
            raiz = new Pagina();

        }
    }
}
