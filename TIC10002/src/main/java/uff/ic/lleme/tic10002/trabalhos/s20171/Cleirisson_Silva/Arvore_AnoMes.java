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
public class Arvore_AnoMes extends ArvoreUtilAno_Mes {

    public NoArvore_AnoMes raiz = null;
    int qtdNos = 0;

    public void inserir(Venda venda) throws InvalidObjectException {
        //Incluir o Nó RAIZ
        if (raiz == null) {
            NoArvore_AnoMes noRaiz = new NoArvore_AnoMes(venda);
            raiz = noRaiz;
            noRaiz.altura = 0;
            qtdNos = 1;

        } else {

            //Se Raiz já não é mais nula - cria novos nós e Inclui a partir dela
            NoArvore_AnoMes noFilhoDaRaizAtual = new NoArvore_AnoMes(venda);

            inserir(raiz, noFilhoDaRaizAtual);

        }

    }

    //Método sobrecarregado com assinatura diferente para...
    //Incluir Nós a partir da raiz != de null
    private void inserir(NoArvore_AnoMes raizAtual, NoArvore_AnoMes noFilhoDaRaizAtual) throws InvalidObjectException {

        //Compara os CPFs dos empregados de cada nó
        //se o CPF contido no Empregado da raiz atual é == ao CPF do empregado da nova Raiz
        // NÃO INCLUI e passa uma exceção
        if (raizAtual.getChave() == noFilhoDaRaizAtual.getChave())
            raizAtual.insereNaLista(noFilhoDaRaizAtual.getListaVenda().getPrimNo().getVenda()); //System.out.println(raizAtual.getListaVenda().imprimir());
        //Compara os CPFs dos empregados de cada nó
        //se o CPF contido no Empregado da raiz atual é MENOR(<) que ao CPF do empregado do novoNoArvoreFilhoDaRaizAtual
        //A comparação retorna -1 < 0
        //Vai Incluir a ESQUERDA do nó raizAtual
        else if (raizAtual.getChave() > noFilhoDaRaizAtual.getChave())

            //Se a raiz O FE da raizAtual aponta para null
            //cria um nó só para retornar a chamada do retornada pelo método conectar
            if (raizAtual.getfE() == null) {
                NoArvore_AnoMes noRetorno = raizAtual.conectarFilhoComPai(noFilhoDaRaizAtual);

                qtdNos++;

                //Senão caminha na arvore à ESQUERDA até encontrar um filho esquerdo == null onde possa incluir
            } else
                inserir(raizAtual.getfE(), noFilhoDaRaizAtual); // System.out.println(noFilhoDaRaizAtual.getListaVenda().imprimir()); //Compara os CPFs dos empregados de cada nó
        //se o CPF contido no Empregado da raiz atual é MAIOR(>) que ao CPF do empregado do novoNoArvoreFilhoDaRaizAtual
        //A comparação retorna 1 > 0
        //Vai Incluir a DIREITA do nó raizAtual
        else if (raizAtual.getChave() < noFilhoDaRaizAtual.getChave())

            if (raizAtual.getfD() == null) {
                NoArvore_AnoMes noRetorno = raizAtual.conectarFilhoComPai(noFilhoDaRaizAtual);
                // System.out.println(noFilhoDaRaizAtual.getListaVenda().imprimir());
                qtdNos++;

            } else
                //Caminha na arvore até encontrar um filho Direito == null
                inserir(raizAtual.getfD(), noFilhoDaRaizAtual); //System.out.println(noFilhoDaRaizAtual.getListaVenda().imprimir());

        raizAtual.altura = maior(NoArvore_AnoMes.altura_No(raizAtual.fE), NoArvore_AnoMes.altura_No(raizAtual.fD)) + 1;

        if (Math.abs(raizAtual.fatorDeBalanceamento_No()) >= 2)
            balanceia(raizAtual);
    }

    public double buscarTotalVendidoDeTodasAsFiliaisPorData(NoArvore_AnoMes raizAtual, int anoMesMenor, int anoMesMaior) {

        if (anoMesMenor > anoMesMaior) {
            int aux = anoMesMenor;
            anoMesMenor = anoMesMaior;
            anoMesMaior = aux;
        }

        return ArvoreUtilAno_Mes.em_ordem_DeData(raizAtual, anoMesMenor, anoMesMaior);

    }

    public void balanceia(NoArvore_AnoMes noDesbalanceado) {

        if (noDesbalanceado.fatorDeBalanceamento_No() == 2)
            if (noDesbalanceado.fE.fatorDeBalanceamento_No() == -1)
                rotacaoEsquerdaDireita(noDesbalanceado);
            else
                rotacaoSimplesDireita(noDesbalanceado);
        else if (noDesbalanceado.fD.fatorDeBalanceamento_No() == 1)
            rotacaoDireitaEsquerda(noDesbalanceado);
        else
            rotacaoSimplesEsquerda(noDesbalanceado);
    }

    /**
     * *************************************************************************
     * ** Função que calculao o maior Valor **
     * *************************************************************************
     */
    public int maior(int altura1, int altura2) {
        if (altura1 > altura2)
            return altura1;
        else
            return altura2;
    }

    /**
     * *************************************************************************
     * ** Função que calculao fator de balanceamento do Nó **
     * *************************************************************************
     */
    public void rotacaoSimplesEsquerda(NoArvore_AnoMes noRaizDesbalanceado) {
        NoArvore_AnoMes ptNo, pai;
        pai = noRaizDesbalanceado.pai;

        ptNo = noRaizDesbalanceado.getfD();
        noRaizDesbalanceado.fD = ptNo.fE;
        if (ptNo.fE != null)
            noRaizDesbalanceado.fD.pai = noRaizDesbalanceado;
        ptNo.fE = noRaizDesbalanceado;
        noRaizDesbalanceado.pai = ptNo;

        /**
         * *************************************************************************
         * ** Atualiza as Alturas **
         * *************************************************************************
         */
        noRaizDesbalanceado.altura = maior(NoArvore_AnoMes.altura_No(noRaizDesbalanceado.getfE()), NoArvore_AnoMes.altura_No(noRaizDesbalanceado.fD)) + 1;
        ptNo.altura = maior(NoArvore_AnoMes.altura_No(ptNo.fE), NoArvore_AnoMes.altura_No(ptNo.fD)) + 1;

        if (pai != null) {
            ptNo.pai = pai;
            if (pai.fE == noRaizDesbalanceado)
                pai.fE = ptNo;
            else
                pai.fD = ptNo;
        } else {
            ptNo.pai = null;
            raiz = ptNo;
        }
    }

    public void rotacaoSimplesDireita(NoArvore_AnoMes noRaizDesbalanceado) {
        NoArvore_AnoMes ptNo, pai;
        pai = noRaizDesbalanceado.pai;

        ptNo = noRaizDesbalanceado.getfE();
        noRaizDesbalanceado.fE = ptNo.fD;
        if (ptNo.fD != null)
            noRaizDesbalanceado.fE.pai = noRaizDesbalanceado;
        ptNo.fD = noRaizDesbalanceado;
        noRaizDesbalanceado.pai = ptNo;

        /**
         * *************************************************************************
         * ** Atualiza as Alturas **
         * *************************************************************************
         */
        noRaizDesbalanceado.altura = maior(NoArvore_AnoMes.altura_No(noRaizDesbalanceado.fE), NoArvore_AnoMes.altura_No(noRaizDesbalanceado.fD)) + 1;
        ptNo.altura = maior(NoArvore_AnoMes.altura_No(ptNo.fE), NoArvore_AnoMes.altura_No(ptNo.fD) + 1);

        if (pai != null) {
            ptNo.pai = pai;
            if (pai.fE == noRaizDesbalanceado)
                pai.fE = ptNo;
            else
                pai.fD = ptNo;
        } else {
            ptNo.pai = null;
            raiz = ptNo;
        }

    }

    public void rotacaoEsquerdaDireita(NoArvore_AnoMes noRaizDesbalanceado) {
        rotacaoSimplesEsquerda(noRaizDesbalanceado.getfE());
        rotacaoSimplesDireita(noRaizDesbalanceado);
    }

    public void rotacaoDireitaEsquerda(NoArvore_AnoMes noRaizDesbalanceado) {
        rotacaoSimplesDireita(noRaizDesbalanceado.getfD());
        rotacaoSimplesEsquerda(noRaizDesbalanceado);

    }

    public void imprimirArvore() {
        raiz.printTree();
    }
}
