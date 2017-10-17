package uff.ic.lleme.tic10002.provas.s20171.VR20171Q4;

import java.util.LinkedList;
import java.util.Queue;

public class VR20171Q4 {

    private No raiz = null;

    public class No {

        public Integer chave = null;
        public No direita = null;
        public No esquerda = null;
        public int nivel = 0;

        public No(int chave) {
            this.chave = chave;
        }

        public void printTree() {
            if (esquerda != null)
                esquerda.printTree(false, "");
            printNodeValue();
            if (direita != null)
                direita.printTree(true, "");
        }

        private void printNodeValue() {
            System.out.print("" + chave + "/");
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

    }

    public void print() {
        raiz.printTree();
    }

    public void nivel() {
        nivel(raiz, 0);
    }

    private void nivel(No no, int nivelAnt) {
        no.nivel = nivelAnt + 1;
        if (no.direita != null)
            nivel(no.direita, nivelAnt);
        if (no.esquerda != null)
            nivel(no.esquerda, nivelAnt);
    }

    private void caminharEmAmplitude() {
        Queue<No> fila = new LinkedList<>();

        No corrente = raiz;
        fila.add(corrente);
        while (!fila.isEmpty()) {
            corrente = fila.poll();
            System.out.print("" + corrente.chave + "\t");
            if (corrente.direita != null)
                fila.add(corrente.direita);
            if (corrente.esquerda != null)
                fila.add(corrente.esquerda);
        }
    }

    public void incluir(int chave) {
        if (raiz == null)
            raiz = new No(chave);
        else
            incluir(raiz, new No(chave));
    }

    private void incluir(No no, No novoNo) {
        if (novoNo.chave > no.chave)
            if (no.esquerda == null)
                no.esquerda = novoNo;
            else
                incluir(no.esquerda, novoNo);
        else if (novoNo.chave < no.chave)
            if (no.direita == null)
                no.direita = novoNo;
            else
                incluir(no.direita, novoNo);
    }

    public static void main(String[] args) {
        VR20171Q4 a = new VR20171Q4();
        int[] nums = {34, 1, 78, 12, 3, 14, 67, 7, 6, 24};
        for (int num : nums)
            a.incluir(num);
        a.print();
        System.out.println("");
        a.caminharEmAmplitude();
    }
}
