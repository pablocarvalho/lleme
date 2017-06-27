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
public class NoData {

    // CORRECAO: deveria ser uma lista
    Venda cont;
    NoData pai;
    NoData esq;
    NoData dir;
    int altura = 0;

    public NoData(Venda cont) {
        this.cont = cont;
    }

    public int getChave() {
        return cont.getChave(true);
    }

    @Override
    public String toString() {
        String res = this.cont + " ";

        if (this.esq != null)
            res += this.esq.cont + " ";
        else
            res += "nil ";

        if (this.dir != null)
            res += this.dir.cont + " ";
        else
            res += "nil ";

        return res += " alt: " + this.altura;
    }

    public static int altura(NoData no) {
        if (no == null)
            return -1;
        return no.altura;
    }

    int fatorBalanceamento() {
        return altura(this.esq) - altura(this.dir);
    }

    public void printTree() {
        if (dir != null)
            dir.printTree(false, "");
        printNodeValue();
        if (esq != null)
            esq.printTree(true, "");
    }

    private void printNodeValue() {
        System.out.print("" + this.cont.getData() + "|" + this.cont.getTotal() + "/" + this.fatorBalanceamento());
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
