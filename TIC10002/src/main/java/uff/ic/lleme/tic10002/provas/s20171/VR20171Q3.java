package uff.ic.lleme.tic10002.provas.s20171;

public class VR20171Q3 {

    private No raiz = null;

    public class No {

        public Integer chave = null;
        public No direita = null;
        public No esquerda = null;

        public No(int chave) {
            this.chave = chave;
        }

    }

    public void merge(VR20171Q3 b) {
        caminhar(b.raiz);
    }

    public void caminhar(No no) {
        this.incluir(no.chave);
        if (no.direita != null)
            caminhar(no.direita);
        if (no.esquerda != null)
            caminhar(no.esquerda);
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
        P220171Q3 a = new P220171Q3();
        int[] nums = {34, 1, 78, 12, 3, 14, 67, 7, 6, 24};
        for (int num : nums)
            a.incluir(num);
        System.out.println("" + a.ehAVL());
    }
}
