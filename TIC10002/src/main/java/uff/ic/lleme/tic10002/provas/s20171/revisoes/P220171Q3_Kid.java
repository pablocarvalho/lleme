package uff.ic.lleme.tic10002.provas.s20171.revisoes;

public class P220171Q3_Kid {

    private No raiz = null;
    private boolean avl = false;

    public class No {

        public Integer chave = null;
        public No izq = null;
        public No der = null;
        public int saldo = 0;

        public No(int chave) {
            this.chave = chave;
        }

        public void printTree() {
            if (der != null)
                der.printTree(false, "");
            printNodeValue();
            if (izq != null)
                izq.printTree(true, "");
        }

        private void printNodeValue() {
            System.out.print("" + chave);
            System.out.print('\n');
        }

        private void printTree(boolean isRight, String indent) {
            if (der != null)
                der.printTree(false, indent + (isRight ? " |      " : "        "));
            System.out.print(indent);
            if (isRight)
                System.out.print(" \\");
            else
                System.out.print(" /");
            System.out.print("----- ");
            printNodeValue();
            if (izq != null)
                izq.printTree(true, indent + (isRight ? "        " : " |      "));
        }
    }

    public void print() {
        raiz.printTree();
    }
    private boolean isAVL = true; // enquanto calcula-se o BF posso dizer se um árvore é es AVL

    public boolean isAVL() {
        BF(raiz);
        return isAVL;
    }

    private int BF(No act) { // Factor de Balanceo
        if (act == null)
            return 0;
        if (act.izq == null || act.der == null) // na sua prova o operador logico era OU
            return 1;
        int heightL = BF(act.izq);
        int heightR = BF(act.der);

        if (Math.abs(heightL - heightR) > 1)
            isAVL = false;
        return heightL + heightR + 1;
    }

    public void incluir(int chave) {
        if (raiz == null)
            raiz = new No(chave);
        else
            incluir(raiz, new No(chave));
    }

    private void incluir(No no, No novoNo) {
        if (novoNo.chave > no.chave)
            if (no.der == null)
                no.der = novoNo;
            else
                incluir(no.der, novoNo);
        else if (novoNo.chave < no.chave)
            if (no.izq == null)
                no.izq = novoNo;
            else
                incluir(no.izq, novoNo);
    }

    public static void main(String[] args) {
        P220171Q3_Kid a = new P220171Q3_Kid();
        int[] nums = {34, 1, 78, 12, 3, 14, 67, 7, 6, 24};
        for (int num : nums)
            a.incluir(num);
        System.out.println("" + a.isAVL());
        System.out.println("");
        a.print();
    }
}
