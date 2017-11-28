package uff.ic.lleme.tic10002.provas.s20172.P120172Q2;

import uff.ic.lleme.tic10002.provas.s20172.P120172Q1.Pilha;

public class ListaEncadeada {

    public class No {

        public int conteudo = 0;
        public No proximo = null;

        public No(int x) {
            conteudo = x;
        }
    }

    private No primeiro = null;

    public boolean incluir(int x) {
        if (primeiro == null) {
            primeiro = new No(x);
            return true;
        } else {
            No aux = primeiro;
            primeiro = new No(x);
            primeiro.proximo = aux;
            return true;
        }
    }

    public boolean excluir(int x) {
        if (primeiro == null)
            return false;
        else if (primeiro.conteudo == x) {
            primeiro = primeiro.proximo;
            return true;
        } else
            return excluir(primeiro, x);
    }

    private boolean excluir(No noCorrente, int x) {
        if (noCorrente.proximo != null)
            if (noCorrente.proximo.conteudo == x) {
                noCorrente.proximo = noCorrente.proximo.proximo;
                return true;
            } else
                return excluir(noCorrente.proximo, x);
        else
            return false;
    }

    public Integer buscar(int x) {
        return buscar(primeiro, x);
    }

    private Integer buscar(No noCorrente, int x) {
        if (noCorrente != null)
            if (noCorrente.conteudo == x)
                return noCorrente.conteudo;
            else
                return buscar(noCorrente.proximo, x);
        else
            return null;
    }

    public void imprimeAntecedentes() {
        imprimeAntecedentes(primeiro, new Pilha());
    }

    private void imprimeAntecedentes(No noCorrente, Pilha selecao) {
        if (noCorrente != null)
            if (noCorrente.conteudo >= 0) {
                selecao.empilhar(noCorrente.conteudo);
                imprimeAntecedentes(noCorrente.proximo, selecao);
            } else {
                Integer num, count = 0;
                while ((num = selecao.desempilhar()) != null && count < 5) {
                    System.out.print(num + "  ");
                    count++;
                }
                System.out.println("");
                imprimeAntecedentes(noCorrente.proximo, new Pilha());
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
        ListaEncadeada lista = new ListaEncadeada();
        for (int i = 0; i < 10; i++)
            lista.incluir(i);
        lista.print();
        lista.excluir(7);
        lista.print();
        lista.incluir(934);
        lista.print();
    }

}
