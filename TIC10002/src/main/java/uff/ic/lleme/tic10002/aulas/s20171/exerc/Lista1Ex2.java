package uff.ic.lleme.tic10002.aulas.s20171.exerc;

public class Lista1Ex2 {

    public static void main(String[] args) {

        Integer[] numeros = {2, 7, 8, 6, 8};
        //Sort.quickSort(numeros);

        int freq = 0;
        int maiorFreq = 0;
        int n = numeros[0];

        for (int num : numeros)
            if (n == num)
                freq++;
            else if (freq > maiorFreq) {
                maiorFreq = freq;
                n = num;

            }

    }
}
