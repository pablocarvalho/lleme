package uff.ic.lleme.tic10002.aulas.heaps;

import javax.naming.LimitExceededException;

public class Heap {

    private final Priorizacao[] heap = new Priorizacao[100];
    private int n = 0;

    private class Priorizacao {

        public Tarefa tarefa = null;
        public int prioridade = 0;

        public Priorizacao(Tarefa tarefa, int prioridade) {
            this.tarefa = tarefa;
            this.prioridade = prioridade;
        }
    }

    public void incluir(Tarefa tarefa, int prioridade) throws LimitExceededException {
        if (n < heap.length - 1) {
            heap[n++] = new Priorizacao(tarefa, prioridade);
            subir(n - 1);
        } else
            throw new LimitExceededException();
    }

    public Tarefa remover() {
        Tarefa t = heap[0].tarefa;
        heap[0] = heap[--n];
        heap[n] = null;
        descer(0);
        return t;
    }

    public void alterarPrioridade(int id, int prioridade) {
        heap[id].prioridade = prioridade;
        subir(id);
        descer(id);
    }

    private void subir(int i) {
        int pai = (i - 1) / 2;
        if (pai >= 0) // desnecessario
            if (heap[i].prioridade > heap[pai].prioridade) {
                trocar(i, pai);
                subir(pai);
            }
    }

    private void descer(int i) {
        int filho = 2 * i + 1; //da direita
        if (filho < n) {
            if (filho < n - 1) //tem filho da esquerda
                if (heap[filho + 1].prioridade > heap[filho].prioridade) //escolhe o maior
                    filho = filho + 1;
            if (heap[i].prioridade < heap[filho].prioridade) {
                trocar(i, filho);
                descer(filho);
            }
        }
    }

    private void trocar(int i, int j) {
        Priorizacao aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    public void printHeap() {
        System.out.print("{");
        for (int i = 0; i < heap.length; i++)
            if (heap[i] != null)
                System.out.print(String.format("[%d,%s,%d] ", i, heap[i].tarefa.descricao, heap[i].prioridade));
        System.out.println("}");
    }

}
