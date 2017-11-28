package uff.ic.lleme.tic10002.provas.s20172.P220172Q1;

import com.sun.istack.internal.NotNull;

public class ArvoreBinaria {

    private No raiz = null;
    private int desbalanceados = 0;

    private class No {

        public Conteudo conteudo;
        public No esquerda = null;
        public No direita = null;
        public int saldoAltura = 0;

        public No(@NotNull Conteudo conteudo) {
            if (conteudo == null)
                throw new NullPointerException();
            this.conteudo = conteudo;
        }

        public void printTree() {
            if (esquerda != null)
                esquerda.printTree(false, "");
            printNodeValue();
            if (direita != null)
                direita.printTree(true, "");
        }

        private void printNodeValue() {
            System.out.print("" + conteudo.chave + "/" + saldo());
            System.out.print('\n');
        }

        private void printTree(boolean isRight, String indent) {
            if (esquerda != null)
                esquerda.printTree(false, indent + (isRight ? " |      " : "        "));
            System.out.print(indent);
            if (isRight)
                System.out.print(" \\");
            else
                System.out.print(" /");
            System.out.print("----- ");
            printNodeValue();
            if (direita != null)
                direita.printTree(true, indent + (isRight ? "        " : " |      "));
        }

        private int altura() {
            return Math.max(altura(this.direita), altura(this.esquerda)) + 1;
        }

        private int altura(No no) {
            if (no != null)
                return Math.max(altura(no.direita), altura(no.esquerda)) + 1;
            return 0;
        }

        private int saldo() {
            if (this.direita != null && this.esquerda != null)
                return Math.abs(this.direita.altura() - this.esquerda.altura());
            else if (this.direita != null && this.esquerda == null)
                return Math.abs(this.direita.altura() - 0);
            else if (this.direita == null && this.esquerda != null)
                return Math.abs(0 - this.esquerda.altura());
            return 0;
        }
    }

    public void print() {
        raiz.printTree();
        System.out.println("");
    }

    public Pilha inserir(Conteudo conteudo) {
        if (raiz == null) {
            raiz = new No(conteudo);
            return null;
        } else {
            Pilha caminho = new Pilha();

            inserir(raiz, conteudo, caminho);
            caminho.empilhar(new NoCaminho("R", raiz.conteudo.chave, raiz.saldoAltura));

            if (desbalanceados > 0)
                return caminho;
            else
                return null;
        }

    }

    private void inserir(No no, Conteudo conteudo, Pilha caminho) {
        if (conteudo.chave < no.conteudo.chave)
            if (no.direita == null) {
                no.direita = new No(conteudo);
                caminho.empilhar(new NoCaminho("D", conteudo.chave, 0));

                //<editor-fold defaultstate="collapsed" desc="contagem desbalanceados">
                if (no.saldoAltura == 1)
                    desbalanceados++;
                else if (no.saldoAltura == -2)
                    desbalanceados--;
                //</editor-fold>

                no.saldoAltura++;
            } else {
                int saldoAnteriorU = no.direita.saldoAltura;
                inserir(no.direita, conteudo, caminho);
                caminho.empilhar(new NoCaminho("D", no.direita.conteudo.chave, no.direita.saldoAltura));
                int saldoPosteriorU = no.direita.saldoAltura;

                if (Math.abs(saldoPosteriorU) > Math.abs(saldoAnteriorU)) {

                    //<editor-fold defaultstate="collapsed" desc="contagem desbalanceados">
                    if (no.saldoAltura == 1)
                        desbalanceados++;
                    else if (no.saldoAltura == -2)
                        desbalanceados--;
                    //</editor-fold>

                    no.saldoAltura++;
                }
            }
        else if (conteudo.chave > no.conteudo.chave)
            if (no.esquerda == null) {
                no.esquerda = new No(conteudo);
                caminho.empilhar(new NoCaminho("E", no.esquerda.conteudo.chave, 0));

                //<editor-fold defaultstate="collapsed" desc="contagem desbalanceados">
                if (no.saldoAltura == -1)
                    desbalanceados++;
                else if (no.saldoAltura == 2)
                    desbalanceados--;
                //</editor-fold>

                no.saldoAltura--;
            } else {
                int saldoAnteriorZ = no.esquerda.saldoAltura;
                inserir(no.esquerda, conteudo, caminho);
                caminho.empilhar(new NoCaminho("E", no.esquerda.conteudo.chave, no.esquerda.saldoAltura));
                int saldoPosteriorZ = no.esquerda.saldoAltura;

                if (Math.abs(saldoPosteriorZ) > Math.abs(saldoAnteriorZ)) {

                    //<editor-fold defaultstate="collapsed" desc="contagem desbalanceados">
                    if (no.saldoAltura == -1)
                        desbalanceados++;
                    else if (no.saldoAltura == 2)
                        desbalanceados--;
                    //</editor-fold>

                    no.saldoAltura--;
                }
            }
    }

    public Conteudo buscar(int chave) {
        if (raiz != null)
            return buscar(raiz, chave);
        else
            return null;
    }

    private Conteudo buscar(No no, int chave) {
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
