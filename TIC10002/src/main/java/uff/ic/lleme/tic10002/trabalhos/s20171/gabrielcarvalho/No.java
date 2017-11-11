/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.gabrielcarvalho;

/**
 *
 * @author Frog33
 */
public class No {

    private final int chave;
    ArvoreData cont = new ArvoreData();
    No pai;
    No esq;
    No dir;
    int altura = 0;

    public No(int chave) {
        this.chave = chave;
    }

    public int getChave() {
        return this.chave;
    }

    public static int altura(No no) {
        if (no == null)
            return -1;
        return no.altura;
    }

    int fatorBalanceamento() {
        return altura(this.esq) - altura(this.dir);
    }

    void incluir(Venda v) {
        this.cont.incluir(v);
    }

    public int busca(MesAno menor, MesAno maior) {
        return cont.busca(menor, maior);
    }

    public void printTree() {
        if (dir != null)
            dir.printTree(false, "");
        printNodeValue();
        if (esq != null)
            esq.printTree(true, "");
    }

    private void printNodeValue() {
        System.out.print("" + this.cont.getChave() + "/" + this.fatorBalanceamento());
        System.out.print('\n');
    }

    private void printTree(boolean isRight, String indent) {
        if (dir != null)
            dir.printTree(false, indent + (isRight ? " |      " : "        "));
        System.out.print(indent);
        if (isRight)
            System.out.print(" \\");
        else
            System.out.print(" /");
        System.out.print("----- ");
        printNodeValue();
        if (esq != null)
            esq.printTree(true, indent + (isRight ? "        " : " |      "));
    }
}
