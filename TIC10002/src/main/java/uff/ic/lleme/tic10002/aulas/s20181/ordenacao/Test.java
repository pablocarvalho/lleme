package uff.ic.lleme.tic10002.aulas.s20181.ordenacao;

import uff.ic.lleme.tic10002.aulas.s20181.Objeto;

public class Test {

    public static void main(String[] args) {
        Objeto[] lista1 = {new Objeto(7), new Objeto(22), new Objeto(4), new Objeto(1), new Objeto(2), new Objeto(10), new Objeto(5)};
        lista1 = SelectSort.sort(lista1);
        print(lista1, "Select Sort");

        Objeto[] lista2 = {new Objeto(7), new Objeto(22), new Objeto(4), new Objeto(1), new Objeto(2), new Objeto(10), new Objeto(5)};
        lista2 = BubleSort.sort(lista2);
        print(lista2, "Buble Sort");

        Objeto[] lista3 = {new Objeto(7), new Objeto(22), new Objeto(4), new Objeto(1), new Objeto(2), new Objeto(10), new Objeto(5)};
        lista3 = MergeSort.sort(lista3);
        print(lista3, "Merge Sort");

        Objeto[] lista4 = {new Objeto(7), new Objeto(22), new Objeto(4), new Objeto(1), new Objeto(2), new Objeto(10), new Objeto(5)};
        lista4 = QuickSort.sort(lista4);
        print(lista4, "Quick Sort");
    }

    public static void print(Objeto[] lista, String algoritmo) {
        for (Objeto o : lista)
            System.out.print(o.chave + " ");
        System.out.println("<-- " + algoritmo);
    }
}
