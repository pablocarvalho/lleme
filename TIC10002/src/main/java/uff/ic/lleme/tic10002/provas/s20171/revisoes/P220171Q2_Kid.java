package uff.ic.lleme.tic10002.provas.s20171.revisoes;

public class P220171Q2_Kid {

    private No raiz = null;
    private int quantidadeNos = 0;

    public class No {

        public Integer dato = null;
        public No izq = null;
        public No der = null;

        public No(int chave) {
            this.dato = chave;
        }

    }

    public int successor(int num) {
        No x = buscar(num, raiz);
        if (x == null) {
            System.err.println("O elemento não se encontra na árvore");
            throw new NullPointerException();
        }
        return successor(x).dato;
    }

    private No successor(No act) {
        if (act == null)
            return null;
        if (act.der != null)
            return min(act.der);
        else {
            No n = getPai(raiz, act);
            No m = act;
            while (n != null && m == n.der) {
                m = n;
                n = getPai(raiz, n);
            }
            return n;
        }
    }

    private No min(No act) {
        if (act == null)
            return null;
        if (act.izq != null)
            return min(act.izq);
        return act;
    }

    public No getPai(No root, No node) {
        if (root == null || node == null)
            return null;
        else if ((root.der != null && root.der.dato == node.dato) || (root.izq != null && root.izq.dato == node.dato))
            return root;
        else {
            No encontrado = getPai(root.der, node);
            if (encontrado == null)
                encontrado = getPai(root.izq, node);
            return encontrado;
        }
    }

    public int buscar(int x) {
        No res = buscar(x, raiz);
        assert (res != null);
        return res.dato;
    }

    private No buscar(int x, No n) {
        if (n == null)
            return null;
        else if (n.dato < x)
            return buscar(x, n.der);
        else if (n.dato > x)
            return buscar(x, n.izq);
        else
            return n;
    }

    public void incluir(int chave) {
        if (raiz == null) {
            raiz = new No(chave);
            quantidadeNos = 1;
        } else
            incluir(raiz, new No(chave));
    }

    private void incluir(No no, No novoNo) {
        if (novoNo.dato > no.dato)
            if (no.der == null) {
                no.der = novoNo;
                quantidadeNos++;
            } else
                incluir(no.der, novoNo);
        else if (novoNo.dato < no.dato)
            if (no.izq == null) {
                no.izq = novoNo;
                quantidadeNos++;
            } else
                incluir(no.izq, novoNo);
    }

    public static void main(String[] args) {
        P220171Q2_Kid a = new P220171Q2_Kid();
        int[] nums = {34, 1, 78, 12, 3, 14, 67};
        for (int num : nums)
            a.incluir(num);
        System.out.println("" + a.successor(12));
    }
}
