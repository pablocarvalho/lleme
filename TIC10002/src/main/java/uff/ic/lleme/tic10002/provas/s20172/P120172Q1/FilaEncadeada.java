package uff.ic.lleme.tic10002.provas.s20172.P120172Q1;

public class FilaEncadeada implements Fila {

    public class No {

        public int conteudo = 0;
        public No proximo = null;
        public No anterior = null;

        public No(int x) {
            conteudo = x;
        }
    }

    private No primeiro = null;
    private No ultimo = null;

    public void enfileirar(int x) {
        if (primeiro == null) {
            primeiro = new No(x);
            ultimo = primeiro;
        } else {
            No aux = primeiro;
            primeiro = new No(x);
            primeiro.proximo = aux;
            aux.anterior = primeiro;
        }
    }

    public Integer desenfileirar() {
        if (ultimo == null)
            return null;
        else if (ultimo == primeiro) {
            No saida = ultimo;
            primeiro = null;
            ultimo = null;
            return saida.conteudo;
        } else {
            No saida = ultimo;
            ultimo = saida.anterior;
            ultimo.proximo = null;
            saida.anterior = null;
            return saida.conteudo;
        }
    }

    public void print() {
        print(primeiro);
        System.out.println("");
    }

    private void print(No no) {
        if (no != null) {
            System.out.print(no.conteudo + " ");
            print(no.proximo);
        }
    }

    public static void main(String[] args) {
        FilaEncadeada lista = new FilaEncadeada();
        for (int i = 0; i < 10; i++)
            lista.enfileirar(i);
        lista.print();
        lista.desenfileirar();
        lista.print();
        lista.enfileirar(934);
        lista.print();
    }

}
