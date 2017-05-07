package uff.ic.lleme.tic10002.arvore;

public class Arvore {

    private No raiz = null;

    public No cria(String conteudo) {
        return raiz = new No(conteudo);
    }

}
