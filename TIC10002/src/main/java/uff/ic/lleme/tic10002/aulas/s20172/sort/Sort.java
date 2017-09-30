package uff.ic.lleme.tic10002.aulas.s20172.sort;

public class Sort {

    int[] lista = new int[10];

    public static void main(String[] args) {

    }

    public void sortSelecao(int[] lista) {
        for (int i = 0; i < lista.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < lista.length; j++)
                if (lista[j] < lista[menor])
                    menor = j;
            trocar(lista, i, menor);
        }
    }

    public void sortBolha(int[] lista) {
        boolean trocou;
        int j = 0;
        do {
            trocou = false;
            for (int i = 0; i < lista.length - 1 - j; i++)
                if (lista[i] > lista[i + 1])
                    trocou = trocar(lista, i, i + 1);
            j++;
        } while (trocou);
    }

    private boolean trocar(int[] lista, int i, int menor) {
        int aux = lista[i];
        lista[i] = lista[menor];
        lista[menor] = aux;
        return i != menor;
    }

    private void mergeSort(int[] lista) {
        dividir(lista, 0, lista.length - 1);
    }

    private void dividir(int[] lista, int e, int d) {
        int i = e;
        int j = (e + d) / 2;
        int k = d;
    }

    private int[] merge(int[] lista, int e, int m, int d) {
        int[] result = new int[d - e + 1];
        int il1 = e;
        int il2 = m + 1;
        for (int i = 0; i < result.length; i++)
            if (il1 >= m - e + 1) {
                result[i] = lista[il2];
                il2++;
            } else if (il2 >= d - m) {
                result[i] = lista[il1];
                il1++;
            } else if (lista[il1] < lista[il2]) {
                result[i] = lista[il1];
                il1++;
            } else {
                result[i] = lista[il2];
                il2++;
            }
        return result;
    }

}
