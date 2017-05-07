package uff.ic.lleme.tic10002.provas.s20171;

import java.util.Arrays;

public class QuickSortAdriel {

    private static int tam = 10;
    private static int[] vetor = {7, 81, 14, 52, 31, 43, 4, 3, 7, 31};

    public static void main(String[] args) {
        quickSort(vetor);
        System.out.println("fim");
    }

    public static int ordena() {
        return ordena(0, tam - 1);
    }

    public static int ordena(int inicio, int fim) {
        if (inicio <= fim) {
            int pivo = vetor[(inicio + fim) / 2];

            int i = inicio;
            int j = fim;

            while (i < j) {
                while (vetor[i] < pivo)
                    i++;
                while (vetor[j] > pivo)
                    j--;

                if (i < j) {
                    troca(i, j);
                    if ((vetor[i] != pivo) || (vetor[(inicio + fim) / 2] == pivo))
                        i++;
                    if ((vetor[j] != pivo) || (vetor[(inicio + fim) / 2] == pivo))
                        j--;
                }
                //DIDATICO
                System.out.println("\nVetor: ");
                for (int l = 0; l < tam; ++l)
                    System.out.println(vetor[l] + "   ");
                System.out.println("   |    pivo: ");

            }
            if (j > inicio)
                ordena(inicio, j - 1);
            if (i < fim)
                ordena(j + 1, fim - 1);
        }
        return 0;
    }

    private static int troca(int i, int j) {
        int aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
        return 0;
    }

    private static void print(int[] lista, int tipo) {
        if (tipo == 1)
            System.out.print("--> " + Arrays.toString(lista));
        else
            System.out.print("    " + Arrays.toString(lista));
        System.out.println("");
    }
}
