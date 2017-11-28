package uff.ic.lleme.tic10002.provas.s20172.P120172Q1;

import java.util.Random;

public class FilaSequencial implements Fila {

    public int[] conteudo = new int[50];
    public int i = 0;
    public int j = 0;
    public int n = 0;

    public void enfileirar(int x) {
        if (n < conteudo.length) {
            conteudo[j] = x;
            j = ++j % conteudo.length;
            n++;
        }
    }

    public Integer desenfileirar() {
        Integer x = null;
        if (n > 0) {
            x = conteudo[i];
            i = ++i % conteudo.length;
            n--;
        }
        return x;
    }

    public int tamanho() {
        return n;
    }

    public int capacidade() {
        return conteudo.length;
    }

    public void print() {
        for (int k = 0; k < n; k++)
            System.out.print(conteudo[(i + k) % conteudo.length] + " ");
        System.out.println("");
    }

    public static void main(String[] args) throws Exception {
        FilaSequencial f = new FilaSequencial();
        Random num = new Random();

        for (int i = 0; i < 10; i++)
            f.enfileirar(num.nextInt(100));
        f.print();
        f.desenfileirar();
        f.enfileirar(num.nextInt(100));
        f.print();
        f.desenfileirar();
        f.enfileirar(num.nextInt(100));
        f.print();
        f.desenfileirar();
        f.enfileirar(num.nextInt(100));
        f.print();

    }
}
