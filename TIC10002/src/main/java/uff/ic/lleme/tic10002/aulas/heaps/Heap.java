package uff.ic.lleme.tic10002.aulas.heaps;

import java.util.HashMap;
import java.util.Map;
import javax.naming.LimitExceededException;

public class Heap {

    private Map<String, No> hash = new HashMap<>();
    private final No[] lista = new No[100];
    private int n = 0;

    private class No {

        public Tarefa tarefa = null;
        public int prioridade = 0;
        public int indice = 0;

        public No(Tarefa tarefa, int prioridade, int indice) {
            this.tarefa = tarefa;
            this.prioridade = prioridade;
            this.indice = indice;
        }
    }

    public void printHeap() {
        System.out.print("{");
        for (int i = 0; i < lista.length; i++)
            if (lista[i] != null)
                System.out.print(String.format("[%d,%s,%d] ", i, lista[i].tarefa.codigo, lista[i].prioridade));
        System.out.println("}");
    }

    public void inserir(Tarefa tarefa, int prioridade) throws LimitExceededException {
        if (n < lista.length - 1) {
            No novoNo = new No(tarefa, prioridade, n);
            hash.put(novoNo.tarefa.codigo, novoNo);
            lista[n++] = novoNo;
            subir(n - 1);
        } else
            throw new LimitExceededException();
    }

    public Tarefa remover() {
        Tarefa t = lista[0].tarefa;
        lista[0] = lista[--n];
        lista[n] = null;
        descer(0);
        return t;
    }

    public void alterarPrioridade(Tarefa tarefa, int prioridade) {
        No no = hash.get(tarefa.codigo);
        no.prioridade = prioridade;
        subir(no.indice);
        descer(no.indice);
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
        if (j < n) {
            if (j < n - 1)
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
        lista[i].indice = i;
        lista[j] = aux;
        lista[j].indice = j;
    }

}
