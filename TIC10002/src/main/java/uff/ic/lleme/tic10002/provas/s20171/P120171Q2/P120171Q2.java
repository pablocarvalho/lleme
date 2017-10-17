package uff.ic.lleme.tic10002.provas.s20171.P120171Q2;

public class P120171Q2 {

    private class No {

        private int conteudo;
        private No proximo;

        public No(int conteudo) {
            this.conteudo = conteudo;
        }
    }

    private No primeiro = null;
    private int tamanho = 0;

    public void incluir(int elemento) {
        No novo = new No(elemento);
        novo.proximo = primeiro;
        primeiro = novo;
        tamanho++;
    }

    public P120171Q2 obter(int n) {
        P120171Q2 resultado = new P120171Q2();
        return obter(resultado, primeiro, 0, n);
    }

    public P120171Q2 obter(P120171Q2 resultado, No no, int i, int n) {
        int posInvertida = tamanho - i - 1;
        if (posInvertida >= 0) {
            if (posInvertida < n)
                resultado.incluir(no.conteudo);
            obter(resultado, no.proximo, n, i++);
        }
        return resultado;
    }
}
