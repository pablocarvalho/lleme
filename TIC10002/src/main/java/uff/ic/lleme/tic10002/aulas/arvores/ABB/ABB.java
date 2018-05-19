package uff.ic.lleme.tic10002.aulas.arvores.ABB;

import uff.ic.lleme.tic10002.aulas.utils.Conteudo;
import uff.ic.lleme.tic10002.aulas.arvores.AB;

public class ABB extends AB {

    public Conteudo buscar(int chave) {
        return buscar(raiz, chave);
    }

    private Conteudo buscar(No noCorrente, int chave) {
        if (noCorrente != null)
            if (chave == noCorrente.conteudo.chaveAsNum())
                return noCorrente.conteudo;
            else if (chave < noCorrente.conteudo.chaveAsNum())
                return buscar(noCorrente.direita, chave);
            else
                return buscar(noCorrente.esquerda, chave);
        return null;
    }

    public void incluir(Conteudo conteudo) {
        No novoNo = new No(conteudo);
        if (raiz == null) {
            raiz = novoNo;
            quantidadeNos++;
        } else
            incluir(raiz, novoNo);
    }

    private void incluir(No noCorrente, No novoNo) {
        if (noCorrente.conteudo.chaveAsNum() == novoNo.conteudo.chaveAsNum())
            return;
        else if (novoNo.conteudo.chaveAsNum() < noCorrente.conteudo.chaveAsNum())
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

    public Conteudo excluir(int chave) {
        if (raiz != null && raiz.conteudo.chaveAsNum() == chave) {
            No excluido = raiz;
            if (excluido.esquerda != null) {
                raiz = excluido.esquerda;
                incluir(raiz, excluido.direita);
            } else
                raiz = excluido.direita;

            quantidadeNos--;
            quantidadeNos--;
            return excluido.conteudo;
        } else if (raiz != null)
            return excluir(raiz, chave);
        else
            return null;
    }

    private Conteudo excluir(No noCorrente, int chave) {
        if (chave < noCorrente.conteudo.chaveAsNum()) {

            if (noCorrente.direita != null && chave == noCorrente.direita.conteudo.chaveAsNum()) {
                No excluido = noCorrente.direita;
                if (excluido.esquerda != null) {
                    noCorrente.direita = excluido.esquerda;
                    incluir(noCorrente.direita, excluido.esquerda);
                } else
                    noCorrente.direita = excluido.direita;
                quantidadeNos--;
                quantidadeNos--;
                return excluido.conteudo;
            } else if (raiz != null)
                return excluir(noCorrente.direita, chave);

        } else if (noCorrente.esquerda != null && chave == noCorrente.esquerda.conteudo.chaveAsNum()) {
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
