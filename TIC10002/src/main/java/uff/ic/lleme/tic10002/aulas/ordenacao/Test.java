package uff.ic.lleme.tic10002.aulas.ordenacao;

import uff.ic.lleme.tic10002.aulas.utils.Conteudo;

public class Test {

    public static void main(String[] args) {
        Conteudo[] lista1 = {new Conteudo(7), new Conteudo(22), new Conteudo(4), new Conteudo(1), new Conteudo(2), new Conteudo(10), new Conteudo(5)};
        lista1 = SelectSort.sort(lista1);
        print(lista1, "Select Sort");

        Conteudo[] lista2 = {new Conteudo(7), new Conteudo(22), new Conteudo(4), new Conteudo(1), new Conteudo(2), new Conteudo(10), new Conteudo(5)};
        lista2 = BubleSort.sort(lista2);
        print(lista2, "Buble Sort");

        Conteudo[] lista3 = {new Conteudo(7), new Conteudo(22), new Conteudo(4), new Conteudo(1), new Conteudo(2), new Conteudo(10), new Conteudo(5)};
        lista3 = MergeSort.sort(lista3);
        print(lista3, "Merge Sort");

        Conteudo[] lista4 = {new Conteudo(7), new Conteudo(22), new Conteudo(4), new Conteudo(1), new Conteudo(2), new Conteudo(10), new Conteudo(5)};
        lista4 = QuickSort.sort(lista4);
        print(lista4, "Quick Sort");
    }

    public static void print(Conteudo[] lista, String algoritmo) {
        for (Conteudo o : lista)
            System.out.print(o.chaveAsNum() + " ");
        System.out.println("<-- " + algoritmo);
    }
}
