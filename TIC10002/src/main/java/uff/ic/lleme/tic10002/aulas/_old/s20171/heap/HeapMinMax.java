package uff.ic.lleme.tic10002.aulas._old.s20171.heap;

import javax.naming.LimitExceededException;
import uff.ic.lleme.tic10002.aulas._old.s20171.Tarefa;

public class HeapMinMax {

    private final No[] lista = new No[100];
    private int n = 0;

    private class No {

        public Tarefa conteudo = null;
        public int prioridade = 0;

        public No(Tarefa tarefa, int prioridade) {
            this.conteudo = tarefa;
            this.prioridade = prioridade;
        }
    }

    public void inserir(Tarefa tarefa, int prioridade) throws LimitExceededException {
        if (n < lista.length - 1) {
            lista[n++] = new No(tarefa, prioridade);
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
        int menor = menorEntreFihosENetos(i);
        if (menor != i)
            if (menor != fD && menor != fE) {// eh neto
                if (lista[menor].prioridade < lista[i].prioridade) {
                    trocar(i, menor);
                    int pai = (menor - 1) / 2;
                    if (lista[menor].prioridade > lista[pai].prioridade)
                        trocar(menor, pai);
                    descerMin(menor);
                }
            } else if (lista[menor].prioridade < lista[i].prioridade) // eh filho
                trocar(i, menor);
    }

    private void descerMax(int i) {
        int fD = (2 * i) + 1;
        int fE = (2 * i) + 2;
        int maior = maiorEntreFihosENetos(i);
        if (maior != i)
            if (maior != fD && maior != fE) {// eh neto
                if (lista[maior].prioridade > lista[i].prioridade) {
                    trocar(i, maior);
                    int pai = (maior - 1) / 2;
                    if (lista[maior].prioridade < lista[pai].prioridade)
                        trocar(maior, pai);
                    descerMax(maior);
                }
            } else if (lista[maior].prioridade > lista[i].prioridade) // eh filho
                trocar(i, maior);
    }

    private void subir(int i) {
        int pai = (i - 1) / 2;
        if (nivel(i) % 2 == 0)// nivel de maximos
            if (pai >= 0 && lista[i].prioridade < lista[pai].prioridade) {
                trocar(i, pai);
                subirMin(pai);
            } else
                subirMax(i);
        else if (pai >= 0 && lista[i].prioridade > lista[pai].prioridade) { // nivel de minimos
            trocar(i, pai);
            subirMax(pai);
        } else
            subirMin(i);
    }

    private void subirMin(int i) {
        int pai = (i - 1) / 2;
        int avo = (int) Math.floor((pai - 1) / 2.0);
        if (avo >= 0)
            if (lista[i].prioridade < lista[avo].prioridade) {
                trocar(i, avo);
                subirMin(i);
            }
    }

    private void subirMax(int i) {
        int pai = (i - 1) / 2;
        int avo = (int) Math.floor((pai - 1) / 2.0);
        if (avo >= 0)
            if (lista[i].prioridade > lista[avo].prioridade) {
                trocar(i, avo);
                subirMax(i);
            }
    }

    private int menorEntreFihosENetos(int i) {
        int menor = i;
        int fD = (2 * i) + 1;
        int fE = (2 * i) + 2;
        if (fD < n) {
            menor = fD;
            int[] idxs = {fE, (2 * fD) + 1, (2 * fD) + 2, (2 * fE) + 1, (2 * fE) + 2};
            for (int j = 0; idxs[j] < n && j < idxs.length; j++)
                if (lista[idxs[j]].prioridade < lista[menor].prioridade)
                    menor = idxs[j];
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
                if (lista[idxs[j]].prioridade > lista[maior].prioridade)
                    maior = idxs[j];
        }
        return maior;
    }

    private int nivel(int i) {
        return ((int) (Math.log10(i + 1) / Math.log10(2))) + 1;
    }

    public void trocar(int i, int j) {
        No aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }

    public void printHeap() {
        System.out.print("{");
        for (int i = 0; i < n; i++)
            System.out.print(String.format("[%d,%s,%d] ", i, lista[i].conteudo.descricao, lista[i].prioridade));
        System.out.println("}");
    }
}
