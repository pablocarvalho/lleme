package uff.ic.lleme.tic10002.prova.s20171.revisoes;

public class QuickSortRicardo {
//Declara variáveis globais a serem usadas em todo o algoritmo.

    private static int[] vetAux;
    private static int tamVet;
    //declara o vetor, carrega valores e chama a primeira função que chamará o Quick Sort/
    // Coloquei os valores da prova para teste....

    public static void main(String[] args) {
        int[] vetor = {7, 81, 14, 52, 31, 43, 4, 3, 7, 31};
        print(vetor, 1);
        sort(vetor);
        print(vetor, 1);

    }

    public static void sort(int[] valores) {
        // Verifica se o array está vazio ou nulo
        if (valores == null || valores.length == 0)
            return;
        //Carrega valores no vetor auxiliar, informa o tamanho do vetor, chama a ordenação.
        vetAux = valores;
        tamVet = valores.length;
        //Passa os parametros do Quick Sort, (esq e dir)
        quicksort(0, tamVet - 1);
    }
    //Como declarado em quicksort(0, tamVet - 1); carrega os valores de esq=0 e dir.

    private static void quicksort(int esq, int dir) {
        int i = esq, j = dir;
        // Pega o Pivo do meio da lista - Valor da esquerda + (direita - Esq)/2 para sempre
        //localizar corretamente o Pivo. (Seleciona o Pivo conforme a sua lógica na partição.)
        int pivo = vetAux[esq + (dir - esq) / 2];

        // Divide em duas Listas
        while (i <= j) {
            //Se o valor atual da lista da esquerda é menor que o Pivo
            // em seguida, obter o próximo elemento da lista à esquerda
            while (vetAux[i] < pivo)
                i++;

            //Se o valor atual da lista da direita for maior do que o elemento pivo,
            //em seguida, obter o próximo elemento da lista da direita
            while (vetAux[j] > pivo)
                j--;

            // Se tivermos encontrado um valor na lista da esquerda que é maior que
            // o elemento pivo e se tivermos encontrado um valor na lista da direita
            // Que é menor do que o elemento de pivo, então trocamos os valores.
            // Finalizando   podemos incrementar i e j.
            if (i <= j) {
                troca(i, j);
                i++;
                j--;
                print(vetAux, 2);
            }
        }
        // Recursão
        if (esq < j)

            quicksort(esq, j);
        if (i < dir)

            quicksort(i, dir);
    }

    private static void troca(int i, int j) {
        int temp = vetAux[i];
        vetAux[i] = vetAux[j];
        vetAux[j] = temp;
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
