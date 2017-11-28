package uff.ic.lleme.tic10002.provas.s20172.P220172Q1;

public class Pilha {

    private No ultimo = null;

    private class No {

        public NoCaminho conteudo = null;
        public No anterior = null;

        public No(NoCaminho emp) {
            conteudo = emp;
        }

    }

    public void empilhar(NoCaminho noCaminho) {
        if (ultimo == null) {
            No no = new No(noCaminho);
            ultimo = no;
        } else {
            No novo = new No(noCaminho);
            novo.anterior = ultimo;
            ultimo = novo;
        }
    }

    public NoCaminho desemplihar() {
        if (ultimo != null) {
            NoCaminho resultado = ultimo.conteudo;
            ultimo = ultimo.anterior;
            return resultado;
        } else
            return null;
    }

}
