package uff.ic.lleme.tic10002.provas.s20171.revisoes;

public class P220171Q2_Adriel {

    private No raiz = null;

    public class No {

        public Integer value = null;
        public No esquerda = null;
        public No direita = null;

        public No(int chave) {
            this.value = chave;
        }
    }

    public Integer sucessor(int x) {
        int menorMaior = 9999999;
        return suc(menorMaior, x, raiz);
    }

    private int suc(int x, int mm, No no) {
        if (no.value > x && mm < no.value)
            mm = no.value;
        if (x >= no.value)
            suc(x, mm, no.direita);
        if (x < no.value)
            suc(x, mm, no.esquerda);
        return mm;
    }

    public void incluir(int chave) {
        if (raiz == null)
            raiz = new No(chave);
        else
            incluir(raiz, new No(chave));
    }

    private void incluir(No no, No novoNo) {
        if (novoNo.value > no.value)
            if (no.direita == null)
                no.direita = novoNo;
            else
                incluir(no.direita, novoNo);
        else if (novoNo.value < no.value)
            if (no.esquerda == null)
                no.esquerda = novoNo;
            else
                incluir(no.esquerda, novoNo);
    }

    public static void main(String[] args) {
        P220171Q2_Adriel a = new P220171Q2_Adriel();
        int[] nums = {34, 1, 78, 12, 3, 14, 67};
        for (int num : nums)
            a.incluir(num);
        System.out.println("" + a.sucessor(12));
    }
}
