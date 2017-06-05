package uff.ic.lleme.tic10002.heap;

import uff.ic.lleme.tic10002.Tarefa;

public class HeapMinMax {

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

    private int nivel(int i) {
        return (int) (Math.floor(Math.log(i + 1) / Math.log(2)) + 1);
    }

    private void descer(int i) {
        if (nivel(i) % 2 == 0)
            descerMax(i);
        else
            descerMin(i);
    }

    private void descerMax(int i) {
        int menor = menorEntreFihosENetos(i);
        if (menor != i)
            if (menor != (2 * i) + 1 && menor != (2 * i) + 2) // eh neto?
                if (lista[menor].prioridade < lista[i].prioridade) {
                    trocar(i, menor);
                    int pai = (i - 1) / 2;
                    if (lista[menor].prioridade > lista[pai].prioridade)
                        trocar(menor, pai);
                    descerMin(menor);
                } else if (lista[menor].prioridade < lista[i].prioridade)
                    trocar(i, menor);
    }

    private void descerMin(int i) {
        int menor = menorEntreFihosENetos(i);
        if (menor != i)
            if (menor != (2 * i) + 1 && menor != (2 * i) + 2) // eh neto?
                if (lista[menor].prioridade < lista[i].prioridade) {
                    trocar(i, menor);
                    int pai = (i - 1) / 2;
                    if (lista[menor].prioridade > lista[pai].prioridade)
                        trocar(menor, pai);
                    descerMin(menor);
                } else if (lista[menor].prioridade < lista[i].prioridade)
                    trocar(i, menor);
    }

    private void subir(int i) {
        if (nivel(i) % 2 == 0)
            subirMax(i);
        else
            subirMin(i);
    }

    private void subirMax(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void subirMin(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int menorEntreFihosENetos(int i) {
        int f1 = (2 * i) + 1;
        int f2 = (2 * i) + 2;
        int n1 = (2 * f1) + 1;
        int n2 = (2 * f1) + 2;
        int n3 = (2 * f2) + 1;
        int n4 = (2 * f2) + 2;
        int menor = i;
        if (f1 < lista.length) {
            menor = f1;
            if (f2 < lista.length) {
                if (lista[f2].prioridade < lista[menor].prioridade)
                    menor = f2;
                if (n1 < lista.length) {
                    if (lista[n1].prioridade < lista[menor].prioridade)
                        menor = n1;
                    if (n2 < lista.length) {
                        if (lista[n2].prioridade < lista[menor].prioridade)
                            menor = n2;
                        if (n3 < lista.length) {
                            if (lista[n3].prioridade < lista[menor].prioridade)
                                menor = n3;
                            if (n4 < lista.length)
                                if (lista[n4].prioridade < lista[menor].prioridade)
                                    menor = n4;
                        }
                    }
                }
            }
        }
        return menor;
    }

    public void trocar(int i, int j) {
        No aux = lista[i];
        lista[i] = lista[j];
        lista[j] = aux;
    }
}
