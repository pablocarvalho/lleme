package uff.ic.lleme.tic10002.arvore;

import uff.ic.lleme.tic10002.Empregado;

public class ArvoreAVL {

    private No raiz = null;
    private boolean balanceada = false;
    private int maxSaldo = 0;

    public ArvoreAVL(boolean balanceada) {
        this.balanceada = balanceada;
    }

    private class No {

        public Empregado conteudo = null;
        public No pai = null;
        public No esquerda = null;
        public No direita = null;
        public int saldoAltura = 0;

        public No(Empregado conteudo) {
            this.conteudo = conteudo;
        }
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(No no) {
        if (no != null)
            return Math.max(altura(no.direita), altura(no.esquerda)) + 1;
        return 0;
    }

    public int maxSaldo() {
        maxSaldo = 0;
        altura2(raiz);
        return maxSaldo;
    }

    private int altura2(No no) {
        if (no != null) {
            int alturaDireita = altura2(no.direita);
            int alturaEsquerda = altura2(no.esquerda);
            int saldo = Math.abs(alturaDireita - alturaEsquerda);
            if (saldo > maxSaldo)
                maxSaldo = saldo;
            return Math.max(alturaDireita, alturaEsquerda) + 1;
        }
        return 0;
    }

    public boolean inserir(Empregado conteudo) {
        if (raiz == null)
            return (raiz = new No(conteudo)) != null;
        else
            return inserir(raiz, conteudo);

    }

    private boolean inserir(No no, Empregado conteudo) {
        if (no.conteudo.chave == conteudo.chave)
            return false;
        else if (no.conteudo.chave > conteudo.chave)
            if (no.direita == null) {
                no.direita = new No(conteudo);

                //<editor-fold defaultstate="collapsed" desc="comment">
                {
                    no.saldoAltura++;
                }
                //</editor-fold>

                return true;
            } else {
                int saldoAnteriorSubArvoreDireita = no.direita.saldoAltura;
                boolean inserido = inserir(no.direita, conteudo);
                int saldoPosteriorSubArvoreDireita = no.direita.saldoAltura;

                //<editor-fold defaultstate="collapsed" desc="comment">
                {
                    int delta = saldoPosteriorSubArvoreDireita - saldoAnteriorSubArvoreDireita;
                    if (Math.abs(delta) > 0 && saldoPosteriorSubArvoreDireita != 0)
                        no.saldoAltura++;

                    if (Math.abs(no.saldoAltura) > 1 && balanceada)
                        balancearADireita(no, delta);
                }
                //</editor-fold>

                return inserido;
            }
        else if (no.conteudo.chave < conteudo.chave)
            if (no.esquerda == null) {
                no.esquerda = new No(conteudo);

                //<editor-fold defaultstate="collapsed" desc="comment">
                {
                    no.saldoAltura--;
                }
                //</editor-fold>

                return true;
            } else {
                int saldoAnteriorSubArvoreEsquerda = no.esquerda.saldoAltura;
                boolean inserido = inserir(no.esquerda, conteudo);
                int saldoPosteriorSubArvoreEsquerda = no.esquerda.saldoAltura;

                //<editor-fold defaultstate="collapsed" desc="comment">
                {
                    int delta = saldoPosteriorSubArvoreEsquerda - saldoAnteriorSubArvoreEsquerda;
                    if (Math.abs(delta) > 0 && saldoPosteriorSubArvoreEsquerda != 0)
                        no.saldoAltura--;

                    if (Math.abs(no.saldoAltura) > 1 && balanceada)
                        balancearAEsquerda(no, delta);
                }
                //</editor-fold>

                return inserido;
            }
        else
            return false;
    }

    private void balancearADireita(No n1, int delta) {
        if (delta > 0) {
            No n2 = n1.direita;
            Empregado p = n1.conteudo;
            Empregado u = n2.conteudo;
            No t1 = n2.direita;
            No t2 = n2.esquerda;
            No t3 = n1.esquerda;

            n1.conteudo = u;
            n1.direita = t1;
            n1.esquerda = n2;
            n2.conteudo = p;
            n2.direita = t2;
            n2.esquerda = t3;

            n1.saldoAltura = 0;
            n2.saldoAltura = 0;
        } else if (delta < 0) {
            No n2 = n1.direita;
            No n3 = n2.esquerda;
            Empregado p = n1.conteudo;
            Empregado u = n2.conteudo;
            Empregado v = n3.conteudo;
            No t1 = n2.direita;
            No t2 = n3.direita;
            No t3 = n3.esquerda;
            No t4 = n1.esquerda;

            n1.conteudo = v;
            n1.direita = n2;
            n1.esquerda = n3;
            n2.conteudo = u;
            n2.direita = t1;
            n2.esquerda = t2;
            n3.conteudo = p;
            n3.direita = t3;
            n3.esquerda = t4;

            n1.saldoAltura = 0;
            n2.saldoAltura = 0;
            n3.saldoAltura = 0;
        }
    }

    private void balancearAEsquerda(No n1, int delta) {
        if (delta < 0) {
            No n2 = n1.esquerda;
            Empregado p = n1.conteudo;
            Empregado z = n2.conteudo;
            No t1 = n1.direita;
            No t2 = n2.direita;
            No t3 = n2.esquerda;

            n1.conteudo = z;
            n1.direita = n2;
            n1.esquerda = t3;
            n2.conteudo = p;
            n2.direita = t1;
            n2.esquerda = t2;

            n1.saldoAltura = 0;
            n2.saldoAltura = 0;
        } else if (delta > 0) {
            No n2 = n1.esquerda;
            No n3 = n2.direita;
            Empregado p = n1.conteudo;
            Empregado z = n2.conteudo;
            Empregado y = n3.conteudo;
            No t1 = n1.direita;
            No t2 = n3.direita;
            No t3 = n3.esquerda;
            No t4 = n2.esquerda;

            n1.conteudo = y;
            n1.direita = n2;
            n1.esquerda = n3;
            n2.conteudo = p;
            n2.direita = t1;
            n2.esquerda = t2;
            n3.conteudo = z;
            n3.direita = t3;
            n3.esquerda = t4;

            n1.saldoAltura = 0;
            n2.saldoAltura = 0;
            n3.saldoAltura = 0;
        }
    }

    public Empregado buscar(int chave) {
        if (raiz != null)
            return buscar(raiz, chave);
        else
            return null;
    }

    private Empregado buscar(No no, int chave) {
        if (no.conteudo.chave == chave)
            return no.conteudo;
        else if (no.conteudo.chave > chave && no.direita != null)
            return buscar(no.direita, chave);
        else if (no.conteudo.chave < chave && no.direita != null)
            return buscar(no.esquerda, chave);
        else
            return null;
    }
}
