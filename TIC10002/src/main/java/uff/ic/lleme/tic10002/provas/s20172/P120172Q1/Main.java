package uff.ic.lleme.tic10002.provas.s20172.P120172Q1;

public class Main {

    public static void main(String[] args) {
        Pilha pilha = new Pilha();

        for (int i = 0; i < 10; i++)
            pilha.empilhar(i);

        Integer num;
        while ((num = pilha.desempilhar()) != null)
            System.out.print(num + " ");
    }

}
