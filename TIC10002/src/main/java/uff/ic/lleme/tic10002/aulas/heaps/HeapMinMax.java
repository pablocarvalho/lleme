package uff.ic.lleme.tic10002.aulas.heaps;

import javax.naming.LimitExceededException;

public class HeapMinMax {

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

    public void inserir(Tarefa tarefa, int prioridade) throws LimitExceededException {
        if (n < heap.length - 1) {
            heap[n++] = new Priorizacao(tarefa, prioridade);
            subir(n - 1);
        } else
            throw new LimitExceededException();
    }

    private void descer(int i) {
        if (nivel(i) % 2 == 0)
            descerMax(i);// nivel de maximos
        else
            descerMin(i); // nivel de minimos
    }

    private void descerMin(int i) {
        int fD = (2 * i) + 1;
        int fE = (2 * i) + 2;
        int menor = menorEntreIFihosENetos(i);
        if (menor != i)
            if (menor != fD && menor != fE) {// eh neto
                if (heap[menor].prioridade < heap[i].prioridade) {
                    trocar(i, menor);
                    int pai = (menor - 1) / 2;
                    if (heap[menor].prioridade > heap[pai].prioridade)
                        trocar(menor, pai);
                    descerMin(menor);
                }
            } else if (heap[menor].prioridade < heap[i].prioridade) // eh filho
                trocar(i, menor);
    }

    private void descerMax(int i) {
        int fD = (2 * i) + 1;
        int fE = (2 * i) + 2;
        int maior = maiorEntreFihosENetos(i);
        if (maior != i)
            if (maior != fD && maior != fE) {// eh neto
                if (heap[maior].prioridade > heap[i].prioridade) {
                    trocar(i, maior);
                    int pai = (maior - 1) / 2;
                    if (heap[maior].prioridade < heap[pai].prioridade)
                        trocar(maior, pai);
                    descerMax(maior);
                }
            } else if (heap[maior].prioridade > heap[i].prioridade) // eh filho
                trocar(i, maior);
    }

    private void subir(int i) {
        int pai = (i - 1) / 2;
        if (nivel(i) % 2 == 0)// nivel de maximos
            if (pai >= 0 && heap[i].prioridade < heap[pai].prioridade) {
                trocar(i, pai);
                subirMin(pai);
            } else
                subirMax(i);
        else if (pai >= 0 && heap[i].prioridade > heap[pai].prioridade) { // nivel de minimos
            trocar(i, pai);
            subirMax(pai);
        } else
            subirMin(i);
    }

    private void subirMin(int i) {
        if (i > 2) {
            //int pai = (i - 1) / 2;
            int avo = (i - 3) / 4;
            if (heap[i].prioridade < heap[avo].prioridade) {
                trocar(i, avo);
                subirMin(avo);
            }
        }
    }

    private void subirMax(int i) {
        if (i > 2) {
            //int pai = (i - 1) / 2;
            int avo = (i - 3) / 4;
            if (heap[i].prioridade > heap[avo].prioridade) {
                trocar(i, avo);
                subirMax(avo);
            }
        }
    }

    private int menorEntreIFihosENetos(int i) {
        int menor = i;
        int fD = (2 * i) + 1;
        int fE = (2 * i) + 2;
        int fDfD = (2 * fD) + 1;//neto
        int fEfD = (2 * fD) + 2;//neto
        int fDfE = (2 * fE) + 1;//neto
        int fEfE = (2 * fE) + 2;//neto
        if (fD < n) {
            menor = fD;
            int[] idxs = {fDfD, fEfD, fE, fDfE, fEfE};
            for (int j = 0; idxs[j] < n && j < idxs.length; j++)
                if (heap[idxs[j]].prioridade < heap[menor].prioridade) menor = idxs[j];
        }
        return menor;
    }

    private int maiorEntreFihosENetos(int i) {
        int maior = i;
        int fD = (2 * i) + 1;
        int fE = (2 * i) + 2;
        if (fD < n) {
            maior = fD;
            int[] idxs = {fE, (2 * fD) + 1, (2 * fD) + 2, (2 * fE) + 1, (2 * fE) + 2};
            for (int j = 0; idxs[j] < n && j < idxs.length; j++)
                if (heap[idxs[j]].prioridade > heap[maior].prioridade)
                    maior = idxs[j];
        }
        return maior;
    }

    private int nivel(int i) {
        return ((int) (Math.log10(i + 1) / Math.log10(2))) + 1;
    }

    public void trocar(int i, int j) {
        Priorizacao aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    public void printHeap() {
        System.out.print("{");
        for (int i = 0; i < n; i++)
            System.out.print(String.format("[%d,%s,%d] ", i, heap[i].tarefa.descricao, heap[i].prioridade));
        System.out.println("}");
    }
}
