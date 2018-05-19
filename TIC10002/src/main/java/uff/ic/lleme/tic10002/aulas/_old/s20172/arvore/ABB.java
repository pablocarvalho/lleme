package uff.ic.lleme.tic10002.aulas._old.s20172.arvore;

public class ABB {

    private static class No {

        public String conteudo;
        private No pai = null;
        private No esquerda = null;
        private No direita = null;

        public No(String conteudo) {
            this.conteudo = conteudo;
        }
    }

    private No raiz = null;

    public boolean incluir(String conteudo) {
        if (raiz == null) {
            raiz = new No(conteudo);
            return true;
        } else
            return incluir(raiz, conteudo);
    }

    public boolean incluir(No no, String conteudo) {
        if (conteudo.compareTo(no.conteudo) < 0)
            if (no.direita == null) {
                no.direita = new No(conteudo);
                return true;
            } else
                return incluir(no.direita, conteudo);
        else if (conteudo.compareTo(no.conteudo) > 0)
            if (no.esquerda == null) {
                no.esquerda = new No(conteudo);
                return true;
            } else
                return incluir(no.esquerda, conteudo);
        else
            return false;
    }

    public String buscar(String conteudo) {
        return buscar(raiz, conteudo);
    }

    private String buscar(No no, String conteudo) {
        if (no != null)
            if (no.conteudo.equals(conteudo))
                return no.conteudo;
            else if (no.conteudo.compareTo(conteudo) < 0)
                return buscar(no.esquerda, conteudo);
            else
                return buscar(no.direita, conteudo);
        else
            return null;
    }
}
