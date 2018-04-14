package uff.ic.lleme.tic10002.aulas.s20181.listas;

import uff.ic.lleme.tic10002.aulas.s20181.Objeto;

public class ListaEncadeadoOrdenadaDeObjetos implements Lista {

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
        else if (primeiro.conteudo.chave > objeto.chave) {
            No aux = primeiro;
            primeiro = new No(objeto);
            primeiro.proximo = aux;
        } else
            incluir(objeto, primeiro);
    }

    public void incluir(Objeto objeto, No noAtual) {
        if (noAtual.proximo == null
                || noAtual.proximo.conteudo.chave > objeto.chave) {
            No novoNo = new No(objeto);
            No aux = noAtual.proximo;
            noAtual.proximo = novoNo;
            novoNo.proximo = aux;
        } else
            incluir(objeto, noAtual.proximo);
    }

    @Override
    public void excluir(int chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
