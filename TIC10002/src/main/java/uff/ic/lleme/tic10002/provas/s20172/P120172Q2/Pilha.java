package uff.ic.lleme.tic10002.provas.s20172.P120172Q2;

public class Pilha {

    private class No {

        public int conteudo = 0;
        public No proximo = null;

        public No(int x) {
            conteudo = x;
        }
    }
    private No primeiro = null;

    public void empilhar(int x) {
        if (primeiro == null)
            primeiro = new No(x);
        else {
            No primeiro = this.primeiro;
            this.primeiro = new No(x);
            this.primeiro.proximo = primeiro;
        }
    }

    public Integer desempilhar() {
        if (primeiro != null) {
            No primeiro = this.primeiro;
            this.primeiro = primeiro.proximo;
            return primeiro.conteudo;
        }
        return null;
    }

}
