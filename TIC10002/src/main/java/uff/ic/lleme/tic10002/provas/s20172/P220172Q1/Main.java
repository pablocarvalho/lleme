package uff.ic.lleme.tic10002.provas.s20172.P220172Q1;

public class Main {

    public static void main(String[] args) {
        int[] chaves = {23, 45, 27, 34, 1, 10, 78, 83, 102};
        ArvoreBinaria a = new ArvoreBinaria();
        Pilha caminho = null;
        for (int c : chaves) {
            caminho = a.inserir(new Conteudo(c));
            if (caminho != null)
                print(caminho);
        }
    }

    public static void print(Pilha pilha) {
        NoCaminho no;
        while ((no = pilha.desemplihar()) != null)
            System.out.print("(" + no.direcao + "," + no.chave + "," + no.saldoAltura + ") ");
        System.out.println("");
    }

}
