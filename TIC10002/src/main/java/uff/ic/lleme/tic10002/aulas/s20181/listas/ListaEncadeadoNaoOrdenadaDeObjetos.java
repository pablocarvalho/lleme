package uff.ic.lleme.tic10002.aulas.s20181.listas;

import uff.ic.lleme.tic10002.aulas.s20181.Objeto;

public class ListaEncadeadoNaoOrdenadaDeObjetos implements Lista {

    private class No {

        public Objeto conteudo;
        public No proximo;

        private No() {

        }

        public No(Objeto objeto) {
            this.conteudo = objeto;
        }
    }

    private No primeiro = null;

    @Override
    public Objeto buscar(int chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Objeto obter(int pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void incluir(Objeto objeto) {
        if (primeiro == null)
            primeiro = new No(objeto);
        else
            incluir(objeto, primeiro);
    }

    public void incluir(Objeto objeto, No no) {
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
