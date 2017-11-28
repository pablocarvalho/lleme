package uff.ic.lleme.tic10002.provas.s20172.P220172Q2;

public class Main {

    public static void main(String[] args) {
        int[] chaves = {23, 45, 27, 34, 1, 10, 78, 83, 102};
        ArvoreAVL a = new ArvoreAVL();
        for (int c : chaves) {
            a.inserir(c);
            a.print();
            System.out.println("");
        }
    }
}
