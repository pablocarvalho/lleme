package uff.ic.lleme.tic10002.provas;

public class ListaEncadeada {

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

    public ListaEncadeada obter(int n) {
        ListaEncadeada selecao = new ListaEncadeada();
        corrente = primeiro;
        return obter(selecao, n, 0);
    }

    public ListaEncadeada obter(ListaEncadeada selecao, int n, int i) {
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
