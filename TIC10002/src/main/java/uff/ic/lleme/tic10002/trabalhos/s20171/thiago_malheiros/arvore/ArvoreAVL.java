/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tic10002.trabalhos.s20171.thiago_malheiros.arvore;

import java.util.ArrayList;

/**
 *
 * @author Thiago Malheiros Porcino
 */
public class ArvoreAVL {

    protected NoArvoreAVL raiz;

    public void inserir(int k, NoListaEncadeada venda) {
        NoArvoreAVL n = new NoArvoreAVL(k, venda);
        inserirAVL(this.raiz, n, venda);
    }

    public void inserirAVL(NoArvoreAVL aComparar, NoArvoreAVL aInserir, NoListaEncadeada venda) {

        if (aComparar == null)
            this.raiz = aInserir;
        else if (aInserir.getChave() < aComparar.getChave())

            if (aComparar.getEsquerda() == null) {
                aComparar.setEsquerda(aInserir);
                aInserir.setPai(aComparar);
                verificarBalanceamento(aComparar);
                //aInserir.getLista().printLista();

            } else
                inserirAVL(aComparar.getEsquerda(), aInserir, venda);
        else if (aInserir.getChave() > aComparar.getChave())

            if (aComparar.getDireita() == null) {
                aComparar.setDireita(aInserir);
                aInserir.setPai(aComparar);
                verificarBalanceamento(aComparar);
                //aInserir.getLista().printLista();

            } else
                inserirAVL(aComparar.getDireita(), aInserir, venda);
        else if (aInserir.getChave() == aComparar.getChave())
            aComparar.getLista().inserirNoFim(venda);
    }

    public void verificarBalanceamento(NoArvoreAVL atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getBalanceamento();

        if (balanceamento == -2)

            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita()))
                atual = RD(atual);
            else
                atual = RED(atual);
        else if (balanceamento == 2)

            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda()))
                atual = RE(atual);
            else
                atual = RDE(atual);

        if (atual.getPai() != null)
            verificarBalanceamento(atual.getPai());
        else
            this.raiz = atual;
    }

    public void remover(int k) {
        removerAVL(this.raiz, k);
    }

    public void removerAVL(NoArvoreAVL atual, int k) {
        if (atual == null)
            return;
        else if (atual.getChave() > k)
            removerAVL(atual.getEsquerda(), k);
        else if (atual.getChave() < k)
            removerAVL(atual.getDireita(), k);
        else if (atual.getChave() == k)
            removerNoEncontrado(atual);
    }

    public void removerNoEncontrado(NoArvoreAVL aRemover) {
        NoArvoreAVL r;

        if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {

            if (aRemover.getPai() == null) {
                this.raiz = null;
                aRemover = null;
                return;
            }
            r = aRemover;

        } else {
            r = sucessor(aRemover);
            aRemover.setChave(r.getChave());
        }

        NoArvoreAVL p;
        if (r.getEsquerda() != null)
            p = r.getEsquerda();
        else
            p = r.getDireita();

        if (p != null)
            p.setPai(r.getPai());

        if (r.getPai() == null)
            this.raiz = p;
        else {
            if (r == r.getPai().getEsquerda())
                r.getPai().setEsquerda(p);
            else
                r.getPai().setDireita(p);
            verificarBalanceamento(r.getPai());
        }
        r = null;
    }

    public NoArvoreAVL RE(NoArvoreAVL inicial) {

        NoArvoreAVL direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null)
            inicial.getDireita().setPai(inicial);

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null)

            if (direita.getPai().getDireita() == inicial)
                direita.getPai().setDireita(direita);
            else if (direita.getPai().getEsquerda() == inicial)
                direita.getPai().setEsquerda(direita);

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    public NoArvoreAVL RD(NoArvoreAVL inicial) {

        NoArvoreAVL esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null)
            inicial.getEsquerda().setPai(inicial);

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null)

            if (esquerda.getPai().getDireita() == inicial)
                esquerda.getPai().setDireita(esquerda);
            else if (esquerda.getPai().getEsquerda() == inicial)
                esquerda.getPai().setEsquerda(esquerda);

        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    public NoArvoreAVL RED(NoArvoreAVL inicial) {
        inicial.setEsquerda(RE(inicial.getEsquerda()));
        return RD(inicial);
    }

    public NoArvoreAVL RDE(NoArvoreAVL inicial) {
        inicial.setDireita(RD(inicial.getDireita()));
        return RE(inicial);
    }

    public NoArvoreAVL sucessor(NoArvoreAVL q) {
        if (q.getDireita() != null) {
            NoArvoreAVL r = q.getDireita();
            while (r.getEsquerda() != null)
                r = r.getEsquerda();
            return r;
        } else {
            NoArvoreAVL p = q.getPai();
            while (p != null && q == p.getDireita()) {
                q = p;
                p = q.getPai();
            }
            return p;
        }
    }

    private int altura(NoArvoreAVL atual) {
        if (atual == null)
            return -1;

        if (atual.getEsquerda() == null && atual.getDireita() == null)
            return 0;
        else if (atual.getEsquerda() == null)
            return 1 + altura(atual.getDireita());
        else if (atual.getDireita() == null)
            return 1 + altura(atual.getEsquerda());
        else
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
    }

    private void setBalanceamento(NoArvoreAVL no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    final protected ArrayList<NoArvoreAVL> inorder() {
        ArrayList<NoArvoreAVL> ret = new ArrayList<NoArvoreAVL>();
        inorder(raiz, ret);
        return ret;
    }

    final protected void inorder(NoArvoreAVL no, ArrayList<NoArvoreAVL> lista) {
        if (no == null)
            return;
        inorder(no.getEsquerda(), lista);
        lista.add(no);
        inorder(no.getDireita(), lista);
    }

    public NoArvoreAVL buscar(int chave) {
        if (this.raiz != null)
            return buscar(raiz, chave); //busca raiz
        else
            return null; // nao achou raiz
    }

    private NoArvoreAVL buscar(NoArvoreAVL no, int chave) {
        // Se achei a chave retorno o no
        if (no.getChave() == chave)
            return no;
        //Caso contrario busco na subarvore a direita
        else if (chave > no.getChave() && no.getDireita() != null)
            return buscar(no.getDireita(), chave);

        //Ou então na subarvore a esquerda
        else if (chave < no.getChave() && no.getEsquerda() != null)
            return buscar(no.getEsquerda(), chave);

        //Caso contrario de tudo, retorno nulo pois nao encontrei nada
        else
            return null;
    }

}
