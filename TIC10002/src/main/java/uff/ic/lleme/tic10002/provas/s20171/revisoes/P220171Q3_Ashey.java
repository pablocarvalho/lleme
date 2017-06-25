package uff.ic.lleme.tic10002.provas.s20171.revisoes;

public class P220171Q3_Ashey {

    private No raiz = null;

    public class No {

        public Integer chave = null;
        public No efilho = null;
        public No dfilho = null;
        public int saldo = 0;

        public No(int chave) {
            this.chave = chave;
        }

        public void printTree() {
            if (dfilho != null)
                dfilho.printTree(false, "");
            printNodeValue();
            if (efilho != null)
                efilho.printTree(true, "");
        }

        private void printNodeValue() {
            System.out.print("" + chave);
            System.out.print('\n');
        }

        private void printTree(boolean isRight, String indent) {
            if (dfilho != null)
                dfilho.printTree(false, indent + (isRight ? " |      " : "        "));
            System.out.print(indent);
            if (isRight)
                System.out.print(" \\");
            else
                System.out.print(" /");
            System.out.print("----- ");
            printNodeValue();
            if (efilho != null)
                efilho.printTree(true, indent + (isRight ? "        " : " |      "));
        }

    }

    public void print() {
        raiz.printTree();
    }

    public class Retorno {

        public boolean eBalanceada = false;
        public int altura = 0;
    }

    public boolean eBalanceado() {
        if (raiz == null)
            return true;
        int att = 0;
        return altura(raiz, att).eBalanceada; // Em vez de att você colocou altura na prova, estava errado.
    }

    public Retorno altura(No no, int altura) {
        Retorno r = new Retorno();

        if (no == null) {
            r.altura = 0;
            r.eBalanceada = true;
            return r;
        }

        int ealtura = 0;
        int daltura = 0;

        Retorno e = altura(no.efilho, ealtura);
        Retorno d = altura(no.dfilho, daltura);

        if (e.eBalanceada == false)
            r.eBalanceada = false;
        if (!d.eBalanceada == false)
            r.eBalanceada = false;
        if (e.altura > d.altura)
            r.altura = ealtura;
        else
            r.altura = daltura;

        r.eBalanceada = Math.abs(e.altura - d.altura) <= 1;

        return r;
    }

    public void incluir(int chave) {
        if (raiz == null)
            raiz = new No(chave);
        else
            incluir(raiz, new No(chave));
    }

    private void incluir(No no, No novoNo) {
        if (novoNo.chave > no.chave)
            if (no.dfilho == null)
                no.dfilho = novoNo;
            else
                incluir(no.dfilho, novoNo);
        else if (novoNo.chave < no.chave)
            if (no.efilho == null)
                no.efilho = novoNo;
            else
                incluir(no.efilho, novoNo);
    }

    public static void main(String[] args) {
        P220171Q3_Ashey a = new P220171Q3_Ashey();
        int[] nums = {34, 1, 78, 12, 3, 14, 67, 7, 6, 24};
        for (int num : nums)
            a.incluir(num);
        System.out.println("" + a.eBalanceado());
        System.out.println("");
        a.print();
    }
}
