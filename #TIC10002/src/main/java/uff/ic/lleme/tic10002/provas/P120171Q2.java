package uff.ic.lleme.tic10002.provas;

public class P120171Q2 {

    private class No {

        private int conteudo;
        private No proximo;

        public No(int conteudo) {
            this.conteudo = conteudo;
        }
    }

    private No primeiro = null;
    private No corrente = null;
    private int tamanho = 0;

    public void incluir(int elemento) {
        No novo = new No(elemento);
        novo.proximo = primeiro;
        primeiro = novo;
        tamanho++;
    }

    public P120171Q2 obter(int n) {
        P120171Q2 selecao = new P120171Q2();
        corrente = primeiro;
        return obter(selecao, n, 0);
    }

    public P120171Q2 obter(P120171Q2 selecao, int n, int i) {
        int posInvertida = tamanho - i - 1;
        if (posInvertida < n)
            selecao.incluir(corrente.conteudo);

        if (posInvertida >= 0) {
            corrente = corrente.proximo;
            obter(selecao, n, i++);
        }
        return selecao;
    }
}
