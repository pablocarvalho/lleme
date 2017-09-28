package uff.ic.lleme.tic10002.provas.s20171;

public class P220171Q2 {

    private No raiz = null;
    private int quantidadeNos = 0;

    public class No {

        public Integer chave = null;
        public No direita = null;
        public No esquerda = null;

        public No(int chave) {
            this.chave = chave;
        }

    }

    public Integer sucessor(int x) {
        return encontrarX(raiz, x);
    }

    private Integer encontrarX(No no, int x) {
        if (no != null)
            if (no.chave == x)
                return menorMaior(no.esquerda);
            else if (x < no.chave)
                return encontrarX(no.direita, x);
            else
                return encontrarX(no.esquerda, x);
        return null;
    }

    private Integer menorMaior(No no) {
        if (no == null)
            return null;
        else if (no.direita == null)
            return no.chave;
        else
            return menorMaior(no.direita);
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
        P220171Q2 a = new P220171Q2();
        int[] nums = {34, 1, 78, 12, 3, 14, 67};
        for (int num : nums)
            a.incluir(num);
        System.out.println("" + a.sucessor(12));
    }
}
