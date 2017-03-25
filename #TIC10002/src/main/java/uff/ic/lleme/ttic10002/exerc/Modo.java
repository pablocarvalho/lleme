package uff.ic.lleme.ttic10002.exerc;

import uff.ic.lleme.ttic10002.sort.Sort;

public class Modo {

    public static void main(String[] args) {
        Integer[] array = {7, 6, 1, 6, 6, 2, 10, 7}; // não pode conter null
        array = Sort.quickSort(array);

        for (Integer elm : array)
            System.out.println(elm);

        Integer corr = null;
        Integer freq = 0;
        Integer modo = null;
        Integer modoFreq = 0;

        for (Integer elm : array)
            if (!elm.equals(corr)) {
                if (freq > modoFreq) {
                    modo = corr;
                    modoFreq = freq;
                }
                corr = elm;
                freq = 1;
            } else
                freq++;

        System.out.println(String.format("O modo é %1$d", modo));
    }
}
