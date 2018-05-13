package uff.ic.lleme.tic10002.aulas.s20181.listas.implementacoes;

import uff.ic.lleme.tic10002.aulas.s20181.listas.interfaces.Lista;
import uff.ic.lleme.tic10002.aulas.s20181.Conteudo;

public class ListaEncadeadoNaoOrdenadaDeObjetos implements Lista {

    private class No {

        public Conteudo conteudo;
        public No proximo;

        private No() {

        }

        public No(Conteudo objeto) {
            this.conteudo = objeto;
        }
    }

    private No primeiro = null;

    @Override
    public Conteudo buscar(int chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conteudo obter(int pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void incluir(Conteudo objeto) {
        if (primeiro == null)
            primeiro = new No(objeto);
        else
            incluir(objeto, primeiro);
    }

    public void incluir(Conteudo objeto, No no) {
        if (no.proximo == null)
            no.proximo = new No(objeto);
        else
            incluir(objeto, no.proximo);
    }

    @Override
    public void excluir(int chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
