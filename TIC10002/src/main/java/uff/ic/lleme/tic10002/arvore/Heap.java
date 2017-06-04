package uff.ic.lleme.tic10002.arvore;

import javax.naming.LimitExceededException;
import uff.ic.lleme.tic10002.Tarefa;

public class Heap {

    private No[] lista = new No[100];
    private int n = 0;

    private class No {

        public Tarefa conteudo = null;
        public int prioridade = 0;

        public No(Tarefa tarefa, int prioridade) {
            this.conteudo = tarefa;
            this.prioridade = prioridade;
        }
    }

    public Tarefa obterMaiorPrioridade_Heap() {
        return null;
    }

    public void printHeap() {
        System.out.print("{");
        for (int i = 0; i < lista.length; i++)
            if (lista[i] != null)
                System.out.print(String.format("[%d,%s,%d] ", i, lista[i].conteudo.descricao, lista[i].prioridade));
        System.out.println("}");
    }

    public void inserir(Tarefa tarefa, int prioridade) throws LimitExceededException {
        if (n < lista.length) {
            lista[n] = new No(tarefa, prioridade);
            subir(n++);
        } else
            throw new LimitExceededException();
    }

    public Tarefa remover() {
        Tarefa t = lista[0].conteudo;
        lista[0] = lista[--n];
        lista[n] = null;
        descer(0);
        return t;
    }

    public void alterarPrioridade(int id, int prioridade) {
        lista[id].prioridade = prioridade;
        subir(id);
        descer(id);
    }

    public void subir(int i) {
        int pai = (i - 1) / 2;
        if (lista[i].prioridade > lista[pai].prioridade) {
            trocar(i, pai);
            subir(pai);
        }
    }

    public void descer(int i) {
        int j = 2 * i + 1;
        if (j <= n) {
            if (j < n)
                if (lista[j + 1].prioridade > lista[j].prioridade)
                    j = j + 1;
            if (lista[i].prioridade < lista[j].prioridade) {
                trocar(i, j);
                descer(j);
            }
        }
    }

    public void trocar(int i, int j) {
        No aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }
}
