/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos._20171.cleirissonsilva;

import java.io.InvalidObjectException;

/**
 *
 * @author clerissonss
 */
public class Arvore_Filial extends ArvoreUtil_Filial {//implements ColecaoVenda {

    public NoArvoreFilial raiz = null;
    int qtdNos = 0;

    /**
     * *************************************************************************
     ** Todas as funções e procedimentos responsáveis pela insercção na Arvore AVL **
     * *************************************************************************
     */
    public void inserir(Venda venda) throws InvalidObjectException {
        //Incluir o Nó RAIZ
        if (raiz == null) {
            NoArvoreFilial noRaiz = new NoArvoreFilial(venda);
            raiz = noRaiz;
            noRaiz.altura = 0;
            qtdNos = 1;

        } else {

            //Se Raiz já não é mais nula - cria novos nós e Inclui a partir dela
            NoArvoreFilial noFilhoDaRaizAtual = new NoArvoreFilial(venda);

            inserir(raiz, noFilhoDaRaizAtual);

        }

    }

    private void inserir(NoArvoreFilial raizAtual, NoArvoreFilial noFilhoDaRaizAtual) throws InvalidObjectException {

        if (raizAtual.getChave() == noFilhoDaRaizAtual.getChave()) {
            raizAtual.insereNaLista(noFilhoDaRaizAtual.getListaVenda().getPrimNo().getVenda());

        } else if (raizAtual.getChave() > noFilhoDaRaizAtual.getChave()) {

            if (raizAtual.getfE() == null) {
                NoArvoreFilial noRetorno = raizAtual.conectarFilhoComPai(noFilhoDaRaizAtual);

                qtdNos++;

            } else {
                inserir(raizAtual.getfE(), noFilhoDaRaizAtual);

            }

        } else if (raizAtual.getChave() < noFilhoDaRaizAtual.getChave()) {

            if (raizAtual.getfD() == null) {
                NoArvoreFilial noRetorno = raizAtual.conectarFilhoComPai(noFilhoDaRaizAtual);
                qtdNos++;

            } else {

                inserir(raizAtual.getfD(), noFilhoDaRaizAtual);
            }
        }

        raizAtual.altura = maior(NoArvoreFilial.altura_No(raizAtual.fE), NoArvoreFilial.altura_No(raizAtual.fD)) + 1;

        if (Math.abs(raizAtual.fatorDeBalanceamento_No()) >= 2) {
            balanceia(raizAtual);
        }
    }

    /**
     * *************************************************************************
     ** Todas as funções e procedimentos responsáveis pelas buscas **
     * *************************************************************************
     */
    public double buscarTotalVendidoPorFilial(NoArvoreFilial raizAtual, int cod_Filial1, int cod_Filial2) {

        if (cod_Filial1 > cod_Filial2) {
            int aux = cod_Filial1;
            cod_Filial1 = cod_Filial2;
            cod_Filial2 = aux;
        }

        return ArvoreUtil_Filial.em_ordemFilial(raizAtual, cod_Filial1, cod_Filial2);

    }

    public double buscarTotalVendidoPorDataEFilial(NoArvoreFilial raizAtual, int cod_Filial1, int cod_Filial2, int anoMesMenor, int anoMesMaior) {

        if (cod_Filial1 > cod_Filial2) {
            int aux = cod_Filial1;
            cod_Filial1 = cod_Filial2;
            cod_Filial2 = aux;
        }

        if (anoMesMenor > anoMesMaior) {
            int aux = anoMesMenor;
            anoMesMenor = anoMesMaior;
            anoMesMaior = aux;
        }

        return ArvoreUtil_Filial.em_ordemDataFilial(raizAtual, cod_Filial1, cod_Filial2, anoMesMenor, anoMesMaior);

    }

    /**
     * *************************************************************************
     ** Todas as funções e procedimentos responsáveis pelo balanceamento da árvore AVL **
     * *************************************************************************
     */
    public void balanceia(NoArvoreFilial noDesbalanceado) {

        if (noDesbalanceado.fatorDeBalanceamento_No() == 2) {
            if (noDesbalanceado.fE.fatorDeBalanceamento_No() == -1) {
                rotacaoEsquerdaDireita(noDesbalanceado);
            } else {
                rotacaoSimplesDireita(noDesbalanceado);
            }
        } else {
            if (noDesbalanceado.fD.fatorDeBalanceamento_No() == 1) {
                rotacaoDireitaEsquerda(noDesbalanceado);
            } else {
                rotacaoSimplesEsquerda(noDesbalanceado);
            }

        }
    }

    public int maior(int altura1, int altura2) {
        if (altura1 > altura2) {
            return altura1;
        } else {
            return altura2;
        }
    }

    public void rotacaoSimplesEsquerda(NoArvoreFilial noRaizDesbalanceado) {
        NoArvoreFilial ptNo;
        NoArvoreFilial pai;
        pai = noRaizDesbalanceado.pai;

        ptNo = noRaizDesbalanceado.getfD();
        noRaizDesbalanceado.fD = ptNo.fE;
        if (ptNo.fE != null) {
            noRaizDesbalanceado.fD.pai = noRaizDesbalanceado;
        }
        ptNo.fE = noRaizDesbalanceado;
        noRaizDesbalanceado.pai = ptNo;

        noRaizDesbalanceado.altura = maior(NoArvoreFilial.altura_No(noRaizDesbalanceado.getfE()), NoArvoreFilial.altura_No(noRaizDesbalanceado.fD)) + 1;
        ptNo.altura = maior(NoArvoreFilial.altura_No(ptNo.fE), NoArvoreFilial.altura_No(ptNo.fD)) + 1;

        if (pai != null) {
            ptNo.pai = pai;
            if (pai.fE == noRaizDesbalanceado) {
                pai.fE = ptNo;
            } else {
                pai.fD = ptNo;
            }
        } else {
            ptNo.pai = null;
            raiz = ptNo;
        }
    }

    public void rotacaoSimplesDireita(NoArvoreFilial noRaizDesbalanceado) {
        NoArvoreFilial ptNo, pai;
        pai = noRaizDesbalanceado.pai;

        ptNo = noRaizDesbalanceado.getfE();
        noRaizDesbalanceado.fE = ptNo.fD;
        if (ptNo.fD != null) {
            noRaizDesbalanceado.fE.pai = noRaizDesbalanceado;
        }
        ptNo.fD = noRaizDesbalanceado;
        noRaizDesbalanceado.pai = ptNo;

        noRaizDesbalanceado.altura = maior(NoArvoreFilial.altura_No(noRaizDesbalanceado.fE), NoArvoreFilial.altura_No(noRaizDesbalanceado.fD)) + 1;
        ptNo.altura = maior(NoArvoreFilial.altura_No(ptNo.fE), NoArvoreFilial.altura_No(ptNo.fD) + 1);

        if (pai != null) {
            ptNo.pai = pai;
            if (pai.fE == noRaizDesbalanceado) {
                pai.fE = ptNo;
            } else {
                pai.fD = ptNo;
            }
        } else {
            ptNo.pai = null;
            raiz = ptNo;
        }

    }

    public void rotacaoEsquerdaDireita(NoArvoreFilial noRaizDesbalanceado) {
        rotacaoSimplesEsquerda(noRaizDesbalanceado.getfE());
        rotacaoSimplesDireita(noRaizDesbalanceado);
    }

    public void rotacaoDireitaEsquerda(NoArvoreFilial noRaizDesbalanceado) {
        rotacaoSimplesDireita(noRaizDesbalanceado.getfD());
        rotacaoSimplesEsquerda(noRaizDesbalanceado);

    }

    public void imprimirArvore() {
        raiz.printTree();
    }
}
