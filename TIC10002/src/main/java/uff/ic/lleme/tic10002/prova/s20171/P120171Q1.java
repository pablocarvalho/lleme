package uff.ic.lleme.tic10002.prova.s20171;

public class P120171Q1 {

    public static void main(String[] args) {
        int[] numeros1 = {1, 2};
        ListaEstatica l1 = new ListaEstatica(numeros1);

        int[] numeros2 = {1, 2};
        ListaEstatica l2 = new ListaEstatica(numeros2);

        ListaEstatica resultado = l1.uniao(l2);
    }

}
