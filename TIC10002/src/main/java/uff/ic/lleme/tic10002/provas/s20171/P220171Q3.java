package uff.ic.lleme.tic10002.provas.s20171;

public class P220171Q3 {

    private No raiz = null;
    private int quantidadeNos = 0;
    private boolean avl = false;

    public class No {

        public Integer chave = null;
        public No direita = null;
        public No esquerda = null;
        public int saldo = 0;

        public No(int chave) {
            this.chave = chave;
        }

    }

    public boolean ehAVL() {
        avl = true;
        ehAVL(raiz, 1);
        return avl;
    }

    private int ehAVL(No no, int nivel) {
        if (no == null)
            return nivel + 1;
        int nivelD = ehAVL(no.direita, nivel + 1);
        int nivelE = ehAVL(no.esquerda, nivel + 1);
        no.saldo = Math.abs(nivelD - nivelE);
        if (no.saldo > 1)
            avl = false;
        return Math.max(nivelD, nivelE);
    }

    public void incluir(int chave) {
        if (raiz == null) {
            raiz = new No(chave);
            quantidadeNos = 1;
        } else
            incluir(raiz, new No(chave));
    }

    private void incluir(No no, No novoNo) {
        if (novoNo.chave > no.chave)
            if (no.esquerda == null) {
                no.esquerda = novoNo;
                quantidadeNos++;
            } else
                incluir(no.esquerda, novoNo);
        else if (novoNo.chave < no.chave)
            if (no.direita == null) {
                no.direita = novoNo;
                quantidadeNos++;
            } else
                incluir(no.direita, novoNo);
    }

    public static void main(String[] args) {
        P220171Q3 a = new P220171Q3();
        int[] nums = {34, 1, 78, 12, 3, 14, 67, 7, 6, 24};
        for (int num : nums)
            a.incluir(num);
        System.out.println("" + a.ehAVL());
    }
}
