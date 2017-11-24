/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.cleirisson_silva;

import java.io.InvalidObjectException;

/**
 *
 * @author clerissonss
 */
public class NoArvore_AnoMes {

    int chave;
    ListaVenda listaVenda = null;
    NoArvore_AnoMes pai = null;
    NoArvore_AnoMes fE = null;///filhoEsquerdo
    NoArvore_AnoMes fD = null;//filhoDireito
    public int altura = 0;

    public NoArvore_AnoMes() throws InvalidObjectException {
        throw new InvalidObjectException("Venda desconhecida.");
    }

    //Server para inserir uma lista de vendas no Nó da Árvore
    public NoArvore_AnoMes(Venda venda) throws InvalidObjectException {

        ListaVenda listaVenda = new ListaVenda();
        listaVenda.inserirNoInicio(venda);

        chave = venda.getAno_mes();

        if (ehValido(listaVenda))
            this.listaVenda = listaVenda;
        else
            throw new InvalidObjectException("Venda desconhecida ou sem identificacao.");
    }

    //Serve para validar um lista na hora de Incluir um empregado
    public boolean ehValido(ListaVenda listaVenda) {
        return listaVenda != null && listaVenda.getPrimNo() != null;
    }

    //Serve para Inclusão/ Busca /Exclusão
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

    public NoArvore_AnoMes getPai() {
        return pai;
    }

    public void setPai(NoArvore_AnoMes pai) {
        this.pai = pai;
    }

    public NoArvore_AnoMes getfE() {
        return fE;
    }

    public void setfE(NoArvore_AnoMes fE) {
        this.fE = fE;
    }

    public NoArvore_AnoMes getfD() {
        return fD;
    }

    public void setfD(NoArvore_AnoMes fD) {
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
    public static int altura_No(NoArvore_AnoMes no) {
        if (no == null)
            return -1;
        else
            return no.altura;
    }

    //Serve para incluir/ excluir
    //Excluir No Raiz que tem dois filho e um deles é filho Folha
    //Excluir nó que tem os 2 filhos com mais filhos abaixo
    public NoArvore_AnoMes conectarFilhoComPai(NoArvore_AnoMes noFilhoDaRaizAtual) {
        if (noFilhoDaRaizAtual != null)

            //Compara os cod_filia das vendas de cada nó
            //se o  cod_filial contido na venda da raiz atual é MENOR(<) que o cod_filial contido na venda da do noFilhoDaRaizAtual           //A comparação retorna -1 < 0
            //Vai conectar a ESQUERDA do nó raizAtual
            if (getChave() > noFilhoDaRaizAtual.getChave())
                if (this.getfE() == null) {
                    this.setfE(noFilhoDaRaizAtual);
                    noFilhoDaRaizAtual.setPai(this);
                    return noFilhoDaRaizAtual;
                } else
                    //Caminha na arvore até encontrar um filho esquerdo == null
                    return getfE().conectarFilhoComPai(noFilhoDaRaizAtual); //Compara os cod_filial das vendasde cada nó
            //se o  cod_filial contido na venda da raiz atual é MAIOR(>) que o cod_filial contido na venda da do noFilhoDaRaizAtual
            //A comparação retorna -1 < 0
            //Vai conectar a DIREITA do nó raizAtual
            else if (getChave() < noFilhoDaRaizAtual.getChave())
                if (this.getfD() == null) {
                    this.setfD(noFilhoDaRaizAtual);
                    noFilhoDaRaizAtual.setPai(this);
                    return noFilhoDaRaizAtual;
                } else
                    //Caminha na arvore até encontrar um filho Direito == null
                    return getfD().conectarFilhoComPai(noFilhoDaRaizAtual);
        return null;
    }

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
