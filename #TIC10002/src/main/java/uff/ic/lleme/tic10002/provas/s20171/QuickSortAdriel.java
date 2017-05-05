package uff.ic.lleme.tic10002.provas.s20171;

public class QuickSortAdriel {

    private static int[] lista = {7, 81, 14, 52, 31, 43, 4, 3, 7, 31};

    public static void main(String[] args) {
        quickSort(lista);
        System.out.println("fim");
    }

    private static void quickSort(int[] lista) {
        print(lista, 1);
        quickSort(lista, 0, lista.length - 1);
        print(lista, 1);
    }

    private static void quickSort(int[] vet, int inicio, int fim) {
        /* inicia os indices */
        int i = inicio;
        int j = fim;
        int tmp;
        /* verifica se ainda é necessário a ordenacao (> 2 elementos)  */
        if (i >= j)
            return;
        /*  considera o elemento central como pivo*/
        int pivo = vet[(int) (inicio + fim) / 2];
        /* 'corre' todo o vetor até que os indices se encontrem */
        while (i < j) {
            /* 'procura' por um elemento menor ou igual ao pivo*/
            while (i < j && vet[i] < pivo)
                i++;
            /* 'procura' por um elemento maior ou igual ao pivo*/
            while (i < j && vet[j] > pivo)
                j--;
            /* troca os elementos encontrados se os indices nao tivem se cruzado*/
            if (i < j) {
                tmp = vet[i];
                vet[i] = vet[j];
                vet[j] = tmp;
                i++;
                j--;
                print(lista, 2);
            }
        }
        /* se os indices se cruzaram, reorganiza os indices*/
        if (j < i) {
            tmp = j;
            j = i;
            i = tmp;
        }
        /* ordernar o subvetor da esquerda */
        quickSort(vet, inicio, i);
        /* se o pivo escolhido era o primeiro elemento, ordena os demais à direita*/
        if (i == inicio)
            quickSort(vet, i + 1, fim);
        else
            /* ordena o subvetor a direta*/
            quickSort(vet, i, fim);
    }

    private static void print(int[] lista, int tipo) {
        String[] listaAux = new String[lista.length];
        for (int i = 0; i < lista.length; i++)
            listaAux[i] = "" + lista[i];

        if (tipo == 1)
            System.out.print("--> {" + String.join(",", listaAux) + "}");
        else
            System.out.print("    {" + String.join(",", listaAux) + "}");
        System.out.println("");
    }
}
