package uff.ic.lleme.tic10002.arvoreB;

import uff.ic.lleme.tic10002.Empregado;

public class ArvoreB {

    private ListaEntrada pagina = null;

    public void inserir(Empregado empregado) throws Exception {
        if (pagina == null) {
            pagina = new ListaEntrada();
            pagina.inserir(empregado);
        } else {
            Insercao meio = pagina.inserir(empregado);
            pagina = new ListaEntrada();

        }
    }
}
