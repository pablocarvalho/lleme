package uff.ic.lleme.tic10002.aulas.s20181.listas.implementacoes;

import uff.ic.lleme.tic10002.aulas.s20181.listas.interfaces.Lista;
import uff.ic.lleme.tic10002.aulas.s20181.Conteudo;

public class ListaEncadeadaOrdenadaDeObjetos implements Lista {

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
        else if (primeiro.conteudo.chaveAsNum() > objeto.chaveAsNum()) {
            No aux = primeiro;
            primeiro = new No(objeto);
            primeiro.proximo = aux;
        } else
            incluir(objeto, primeiro);
    }

    public void incluir(Conteudo objeto, No noAtual) {
        if (noAtual.proximo == null
                || noAtual.proximo.conteudo.chaveAsNum() > objeto.chaveAsNum()) {
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
