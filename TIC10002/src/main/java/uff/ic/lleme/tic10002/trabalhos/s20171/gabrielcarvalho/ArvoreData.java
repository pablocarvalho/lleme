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
public class ArvoreData {

    private NoData raiz = null;
    int tamanho = 0;

    public int getChave() {
        if (raiz == null)
            return Integer.MIN_VALUE;
        return raiz.getChave();
    }

    public int busca(MesAno menor, MesAno maior) {
        return busca(raiz, menor, maior);
    }

    private int busca(NoData atual, MesAno menor, MesAno maior) {
        if (atual != null) {
            if (atual.cont.getChave(false) < menor.getChave())
                return busca(atual.dir, menor, maior);
            if (atual.cont.getChave(false) > maior.getChave())
                return busca(atual.esq, menor, maior);
            int total = atual.cont.getTotal();
            total += busca(atual.dir, menor, maior);
            return total + busca(atual.esq, menor, maior);
        }
        return 0;
    }

    public void incluir(Venda v) {

        if (raiz == null) {
            raiz = new NoData(v);
            tamanho++;
        } else
            this.incluir(raiz, v);
    }

    private void incluir(NoData atual, Venda v) {
        if (atual == null)
            return;

        /*if(atual.cont.getChave(false) == v.getChave(false)){
            atual.cont.setTotal(v.getTotal());
        }else*/
        {

            boolean b = atual.cont.getChave(false) > v.getChave(false);
            NoData novo;

            if (b)
                if (atual.esq == null) {
                    novo = new NoData(v);
                    atual.esq = novo;
                    novo.pai = atual;
                    tamanho++;
                } else
                    incluir(atual.esq, v);
            else if (atual.dir == null) {
                novo = new NoData(v);
                atual.dir = novo;
                novo.pai = atual;
                tamanho++;
            } else
                incluir(atual.dir, v);
            atual.altura = Math.max(NoData.altura(atual.dir), NoData.altura(atual.esq)) + 1;
            int fb = atual.fatorBalanceamento();
            NoData pai = null;
            NoData aux = atual;

            if (atual != raiz)
                pai = atual.pai;
            boolean filhoDireita = pai != null && atual.equals(pai.dir);

            if (fb > 1)
                if (atual.esq.fatorBalanceamento() > -1)
                    aux = rotacaoDireita(atual);
                else
                    aux = rotacaoDuplaDireita(atual);
            else if (fb < -1)

                if (atual.dir.fatorBalanceamento() < 1)
                    aux = rotacaoEsquerda(atual);
                else
                    aux = rotacaoDuplaEsquerda(atual);
            if (pai != null) {
                aux.pai = pai;
                if (filhoDireita)
                    pai.dir = aux;
                else
                    pai.esq = aux;
            } else
                raiz = aux;
        }
    }

    private NoData rotacaoDuplaDireita(NoData no) {
        NoData aux = rotacaoEsquerda(no.esq);

        no.esq = aux;
        aux.pai = no;

        return rotacaoDireita(no);
    }

    private NoData rotacaoDuplaEsquerda(NoData no) {
        NoData aux = rotacaoDireita(no.dir);

        no.dir = aux;
        aux.pai = no;

        return rotacaoEsquerda(no);
    }

    private NoData rotacaoDireita(NoData desbalanceado) {
        NoData n2 = desbalanceado.esq;
        NoData t1 = n2.esq, t2 = n2.dir;

        desbalanceado.esq = t2;
        if (t2 != null)
            t2.pai = desbalanceado;

        n2.dir = desbalanceado;
        desbalanceado.pai = n2;

        desbalanceado.altura = Math.max(NoData.altura(desbalanceado.dir), NoData.altura(desbalanceado.esq)) + 1;
        n2.altura = Math.max(NoData.altura(n2.esq), NoData.altura(n2.dir)) + 1;
        return n2;
    }

    private NoData rotacaoEsquerda(NoData desbalanceado) {
        NoData n2 = desbalanceado.dir;
        NoData t1 = n2.dir, t2 = n2.esq;

        desbalanceado.dir = t2;
        if (t2 != null)
            t2.pai = desbalanceado;

        n2.esq = desbalanceado;
        desbalanceado.pai = n2;

        desbalanceado.altura = Math.max(NoData.altura(desbalanceado.dir), NoData.altura(desbalanceado.esq)) + 1;
        n2.altura = Math.max(NoData.altura(n2.esq), NoData.altura(n2.dir)) + 1;
        return n2;
    }

    public void imprime() {
        this.imprime(raiz);
    }

    private void imprime(NoData atual) {
        /*if(atual == null) return;

        System.out.print("||" + atual + "\\\\" + atual.fatorBalanceamento() + "||\n");
        this.imprime(atual.esq);
        this.imprime(atual.dir);*/
        raiz.printTree();
    }

    @Override
    public String toString() {
        return this.toString(raiz, "");
    }

    private String toString(NoData atual, String res) {
        if (atual == null)
            return res;
        res += atual;
        this.toString(atual.esq, res);
        this.toString(atual.dir, res);
        return res;
    }

}
