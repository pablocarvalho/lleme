/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.Cleirisson_Silva;

import java.io.InvalidObjectException;

/**
 *
 * @author clerissonss
 */
public class NoArvoreFilial {

    int chave;
    ListaVenda listaVenda = null;
    NoArvoreFilial pai = null;
    NoArvoreFilial fE = null;///filhoEsquerdo
    NoArvoreFilial fD = null;//filhoDireito
    public int altura = 0;

    public NoArvoreFilial() throws InvalidObjectException {
        throw new InvalidObjectException("Venda desconhecida.");
    }

    public NoArvoreFilial(Venda venda) throws InvalidObjectException {

        ListaVenda listaVenda = new ListaVenda();
        listaVenda.inserirNoInicio(venda);

        chave = venda.getCod_filial();

        if (ehValido(listaVenda))
            this.listaVenda = listaVenda;
        else
            throw new InvalidObjectException("Venda desconhecida ou sem identificacao.");
    }

    public boolean ehValido(ListaVenda listaVenda) {
        return listaVenda != null && listaVenda.getPrimNo() != null;
    }

    public ListaVenda getListaVenda() {
        return listaVenda;
    }

    public void setlistaVenda(ListaVenda listaVenda) {
        this.listaVenda = listaVenda;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public NoArvoreFilial getPai() {
        return pai;
    }

    public void setPai(NoArvoreFilial pai) {
        this.pai = pai;
    }

    public NoArvoreFilial getfE() {
        return fE;
    }

    public void setfE(NoArvoreFilial fE) {
        this.fE = fE;
    }

    public NoArvoreFilial getfD() {
        return fD;
    }

    public void setfD(NoArvoreFilial fD) {
        this.fD = fD;
    }

    public Venda insereNaLista(Venda venda) {
        this.getListaVenda().inserirNoInicio(venda);
        return venda;
    }

    public int fatorDeBalanceamento_No() {
        return (altura_No(this.getfE()) - altura_No(this.getfD()));
    }

    /**
     * *************************************************************************
     * ** Função que calcula a altura do Nó **
     * *************************************************************************
     */
    public static int altura_No(NoArvoreFilial no) {
        if (no == null)
            return -1;
        else
            return no.altura;
    }

    public NoArvoreFilial conectarFilhoComPai(NoArvoreFilial noFilhoDaRaizAtual) {
        if (noFilhoDaRaizAtual != null)

            if (getChave() > noFilhoDaRaizAtual.getChave())
                if (this.getfE() == null) {
                    this.setfE(noFilhoDaRaizAtual);
                    noFilhoDaRaizAtual.setPai(this);
                    return noFilhoDaRaizAtual;
                } else

                    return getfE().conectarFilhoComPai(noFilhoDaRaizAtual);
            else if (getChave() < noFilhoDaRaizAtual.getChave())
                if (this.getfD() == null) {
                    this.setfD(noFilhoDaRaizAtual);
                    noFilhoDaRaizAtual.setPai(this);
                    return noFilhoDaRaizAtual;
                } else
                    return getfD().conectarFilhoComPai(noFilhoDaRaizAtual);
        return null;
    }

    /**
     * ***************************************************************************************
     ** Imprime a arvore **
     * *************************************************************************
     */
    public void printTree() {
        if (fD != null)
            fD.printTree(false, "");
        printNodeValue();
        if (fE != null)
            fE.printTree(true, "");
    }

    private void printNodeValue() {
        System.out.print("" + chave + "/" + fatorDeBalanceamento_No() + "" + listaVenda.imprimir());
        System.out.print('\n');
    }

    private void printTree(boolean isRight, String indent) {
        if (fD != null)
            fD.printTree(false, indent + (isRight ? " |      " : "        "));
        System.out.print(indent);
        if (isRight)
            System.out.print(" \\");
        else
            System.out.print(" /");
        System.out.print("----- ");
        printNodeValue();
        if (fE != null)
            fE.printTree(true, indent + (isRight ? "        " : " |      "));
    }

}
