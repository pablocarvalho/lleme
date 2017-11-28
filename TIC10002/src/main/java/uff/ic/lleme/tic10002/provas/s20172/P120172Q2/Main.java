package uff.ic.lleme.tic10002.provas.s20172.P120172Q2;

public class Main {

    public static void main(String[] args) {
        int[] seq = {2, 1, 9, 5, 3, -1, 3, 9, 88, 4, 9, -2, 83, 9, -2, 9, 4, 3, 1, 3};
        ListaEncadeada lista = new ListaEncadeada();
        for (int i = 0; i < seq.length; i++)
            lista.incluir(seq[seq.length - i - 1]);
        lista.print();
        lista.imprimeAntecedentes();
    }

}
