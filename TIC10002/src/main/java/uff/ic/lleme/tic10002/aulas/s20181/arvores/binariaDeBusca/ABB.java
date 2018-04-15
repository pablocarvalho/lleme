package uff.ic.lleme.tic10002.aulas.s20181.arvores.binariaDeBusca;

import java.io.InvalidObjectException;
import uff.ic.lleme.tic10002.aulas.s20181.Objeto;
import uff.ic.lleme.tic10002.aulas.s20181.arvores.ArvoreBinaria;

public class ABB extends ArvoreBinaria {

    public Objeto buscar(int chave) {
        return buscar(raiz, chave);
    }

    private Objeto buscar(No noCorrente, int chave) {
        if (noCorrente != null)
            if (chave == noCorrente.conteudo.chave)
                return noCorrente.conteudo;
            else if (chave < noCorrente.conteudo.chave)
                return buscar(noCorrente.direita, chave);
            else
                return buscar(noCorrente.esquerda, chave);
        return null;
    }

    public void incluir(Objeto conteudo) throws InvalidObjectException {
        No novoNo = new No(conteudo);
        if (raiz == null) {
            raiz = novoNo;
            quantidadeNos++;
        } else
            incluir(raiz, novoNo);
    }

    private void incluir(No noCorrente, No novoNo) {
        if (noCorrente.conteudo.chave == novoNo.conteudo.chave)
            return;
        else if (novoNo.conteudo.chave < noCorrente.conteudo.chave)
            if (noCorrente.direita == null) {
                noCorrente.direita = novoNo;
                quantidadeNos++;
            } else
                incluir(noCorrente.direita, novoNo);
        else if (noCorrente.esquerda == null) {
            noCorrente.esquerda = novoNo;
            quantidadeNos++;
        } else
            incluir(noCorrente.esquerda, novoNo);
    }

    public Objeto excluir(int chave) {
        if (raiz != null && raiz.conteudo.chave == chave) {
            No excluido = raiz;
            raiz = excluido.direita;
            incluir(raiz, excluido.esquerda);
            quantidadeNos--;
            quantidadeNos--;
            return excluido.conteudo;
        } else if (raiz != null)
            return excluir(raiz, chave);
        else
            return null;
    }

    private Objeto excluir(No noCorrente, int chave) {
        if (chave < noCorrente.direita.conteudo.chave) {

            if (noCorrente.direita != null && chave == noCorrente.direita.conteudo.chave) {
                No excluido = noCorrente.direita;
                noCorrente.direita = excluido.direita;
                incluir(noCorrente.direita, excluido.esquerda);
                quantidadeNos--;
                quantidadeNos--;
                return excluido.conteudo;
            } else if (raiz != null)
                return excluir(noCorrente.direita, chave);

        } else if (noCorrente.esquerda != null && chave == noCorrente.esquerda.conteudo.chave) {
            No excluido = noCorrente.esquerda;
            noCorrente.esquerda = excluido.direita;
            incluir(noCorrente.esquerda, excluido.esquerda);
            quantidadeNos--;
            quantidadeNos--;
            return excluido.conteudo;
        } else if (raiz != null)
            return excluir(noCorrente.esquerda, chave);

        return null;

    }
}
