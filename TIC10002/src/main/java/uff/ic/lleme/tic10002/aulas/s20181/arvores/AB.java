package uff.ic.lleme.tic10002.aulas.s20181.arvores;

import uff.ic.lleme.tic10002.aulas.s20181.Objeto;

public class AB {

    protected No raiz = null;
    protected int quantidadeNos = 0;

    protected class No {

        public Objeto conteudo = null;
        public No pai = null;
        public No esquerda = null;
        public No direita = null;

        public No(Objeto conteudo) {
            this.conteudo = conteudo;
        }

        private void printNodeValue() {
            System.out.print("" + conteudo.chave);
            System.out.print('\n');
        }

        public void print() {
            if (esquerda != null)
                esquerda.print(false, "");
            printNodeValue();
            if (direita != null)
                direita.print(true, "");
        }

        private void print(boolean isRight, String indent) {
            if (esquerda != null)
                esquerda.print(false, indent + (isRight ? " |      " : "        "));
            System.out.print(indent);
            if (isRight)
                System.out.print(" \\");
            else
                System.out.print(" /");
            System.out.print("----- ");
            printNodeValue();
            if (direita != null)
                direita.print(true, indent + (isRight ? "        " : " |      "));
        }

    }

    public void printTree() {
        raiz.print();
        System.out.println("");
    }
}
