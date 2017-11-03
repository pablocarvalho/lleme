package uff.ic.lleme.tic10002.provas.s20171.P220171Q4;

public class P220171Q4 {

    private No raiz = null;
    private boolean balanceada = false;
    private int maxSaldo = 0;

    public P220171Q4(boolean balanceada) {
        this.balanceada = balanceada;
    }

    private class No {

        public Integer chave = null;
        public No esquerda = null;
        public No direita = null;
        public int saldoAltura = 0;

        public No(Integer conteudo) {
            this.chave = conteudo;
        }

        public void printTree() {
            if (esquerda != null)
                esquerda.printTree(false, "");
            printNodeValue();
            if (direita != null)
                direita.printTree(true, "");
        }

        private void printNodeValue() {
            System.out.print("" + chave + "/" + saldo());
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
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(No no) {
        if (no != null)
            return Math.max(altura(no.direita), altura(no.esquerda)) + 1;
        return 0;
    }

    public int maxSaldo() {
        maxSaldo = 0;
        altura2(raiz);
        return maxSaldo;
    }

    private int altura2(No no) {
        if (no != null) {
            int alturaDireita = altura2(no.direita);
            int alturaEsquerda = altura2(no.esquerda);
            int saldoSubArvores = Math.abs(alturaDireita - alturaEsquerda);
            if (saldoSubArvores > maxSaldo)
                maxSaldo = saldoSubArvores;
            return Math.max(alturaDireita, alturaEsquerda) + 1;
        }
        return 0;
    }

    public boolean incluir(Integer conteudo) {
        if (raiz == null)
            return (raiz = new No(conteudo)) != null;
        else
            return inserir(raiz, conteudo);

    }

    private boolean inserir(No no, Integer conteudo) {
        if (no.chave == conteudo)
            return false;
        else if (no.chave > conteudo)
            if (no.direita == null) {
                no.direita = new No(conteudo);

                //<editor-fold defaultstate="collapsed" desc="balanceamento">
                no.saldoAltura++;
                //</editor-fold>

                return true;
            } else {

                //<editor-fold defaultstate="collapsed" desc="balanceamento">
                int saldoAnteriorU = no.direita.saldoAltura;
                int saldoAnteriorV = 0;
                if (no.direita.esquerda != null)
                    saldoAnteriorV = no.direita.esquerda.saldoAltura;
                //</editor-fold>

                boolean inserido = inserir(no.direita, conteudo);

                //<editor-fold defaultstate="collapsed" desc="balanceamento">
                int saldoPosteriorU = no.direita.saldoAltura;
                int saldoPosteriorV = 0;
                if (no.direita.esquerda != null)
                    saldoPosteriorV = no.direita.esquerda.saldoAltura;

                int delta1 = saldoPosteriorU - saldoAnteriorU;
                int delta2 = saldoPosteriorV - saldoAnteriorV;

                if (Math.abs(delta1) > 0 && saldoPosteriorU != 0) {
                    no.saldoAltura++;
                    if (Math.abs(no.saldoAltura) > 1 && balanceada)
                        balancearADireita(no, delta1, delta2);
                }
                //</editor-fold>

                return inserido;
            }
        else if (no.chave < conteudo)
            if (no.esquerda == null) {
                no.esquerda = new No(conteudo);

                //<editor-fold defaultstate="collapsed" desc="balanceamento">
                no.saldoAltura--;
                //</editor-fold>

                return true;
            } else {

                //<editor-fold defaultstate="collapsed" desc="balanceamento">
                int saldoAnteriorZ = no.esquerda.saldoAltura;
                int saldoAnteriorY = 0;
                if (no.esquerda.direita != null)
                    saldoAnteriorY = no.esquerda.direita.saldoAltura;
                //</editor-fold>

                boolean inserido = inserir(no.esquerda, conteudo);

                //<editor-fold defaultstate="collapsed" desc="balanceamento">
                int saldoPosteriorZ = no.esquerda.saldoAltura;
                int saldoPosteriorY = 0;
                if (no.esquerda.direita != null)
                    saldoPosteriorY = no.esquerda.direita.saldoAltura;

                int delta1 = saldoPosteriorZ - saldoAnteriorZ;
                int delta2 = saldoPosteriorY - saldoAnteriorY;

                if (Math.abs(delta1) > 0 && saldoPosteriorZ != 0) {
                    no.saldoAltura--;
                    if (Math.abs(no.saldoAltura) > 1 && balanceada)
                        balancearAEsquerda(no, delta1, delta2);
                }
                //</editor-fold>

                return inserido;
            }
        else
            return false;
    }

    private void balancearADireita(No n1, int delta1, int delta2) {
        if (delta1 > 0) {
            No n2 = n1.direita;
            Integer p = n1.chave;
            Integer u = n2.chave;
            No t1 = n2.direita;
            No t2 = n2.esquerda;
            No t3 = n1.esquerda;

            n1.chave = u;
            n1.direita = t1;
            n1.esquerda = n2;
            n2.chave = p;
            n2.direita = t2;
            n2.esquerda = t3;

            n1.saldoAltura = 0;
            n2.saldoAltura = 0;
        } else if (delta1 < 0) {
            No n2 = n1.direita;
            No n3 = n2.esquerda;
            Integer p = n1.chave;
            Integer u = n2.chave;
            Integer v = n3.chave;
            No t1 = n2.direita;
            No t2 = n3.direita;
            No t3 = n3.esquerda;
            No t4 = n1.esquerda;

            n1.chave = v;
            n1.direita = n2;
            n1.esquerda = n3;
            n2.chave = u;
            n2.direita = t1;
            n2.esquerda = t2;
            n3.chave = p;
            n3.direita = t3;
            n3.esquerda = t4;

            n1.saldoAltura = 0;
            if (t2 == null && t3 == null) {
                n2.saldoAltura = 0;
                n3.saldoAltura = 0;
            } else if (delta2 > 0) {
                n2.saldoAltura = 0;
                n3.saldoAltura = -1;
            } else {
                n2.saldoAltura = 1;
                n3.saldoAltura = 0;
            }
        }
    }

    private void balancearAEsquerda(No n1, int delta, int delta2) {
        if (delta < 0) {
            No n2 = n1.esquerda;
            Integer p = n1.chave;
            Integer z = n2.chave;
            No t1 = n1.direita;
            No t2 = n2.direita;
            No t3 = n2.esquerda;

            n1.chave = z;
            n1.direita = n2;
            n1.esquerda = t3;
            n2.chave = p;
            n2.direita = t1;
            n2.esquerda = t2;

            n1.saldoAltura = 0;
            n2.saldoAltura = 0;
        } else if (delta > 0) {
            No n2 = n1.esquerda;
            No n3 = n2.direita;
            Integer p = n1.chave;
            Integer z = n2.chave;
            Integer y = n3.chave;
            No t1 = n1.direita;
            No t2 = n3.direita;
            No t3 = n3.esquerda;
            No t4 = n2.esquerda;

            n1.chave = y;
            n1.direita = n2;
            n1.esquerda = n3;
            n2.chave = p;
            n2.direita = t1;
            n2.esquerda = t2;
            n3.chave = z;
            n3.direita = t3;
            n3.esquerda = t4;

            n1.saldoAltura = 0;
            if (t2 == null && t3 == null) {
                n2.saldoAltura = 0;
                n3.saldoAltura = 0;
            } else if (delta2 < 0) {
                n2.saldoAltura = 1;
                n3.saldoAltura = 0;
            } else {
                n2.saldoAltura = 0;
                n3.saldoAltura = -1;
            }
        }
    }

    public Integer buscar(int chave) {
        if (raiz != null)
            return buscar(raiz, chave);
        else
            return null;
    }

    private Integer buscar(No no, int chave) {
        if (no.chave == chave)
            return no.chave;
        else if (no.chave > chave && no.direita != null)
            return buscar(no.direita, chave);
        else if (no.chave < chave && no.direita != null)
            return buscar(no.esquerda, chave);
        else
            return null;
    }

    public static void main(String[] args) {
        P220171Q4 a = new P220171Q4(true);
        for (int i = 2; i <= 10; i = i + 2) {
            Integer[] nums = new Integer[i];
            int index = 0;
            for (int j = 1; j <= i; j++)
                nums[index++] = j;
            for (int num : nums)
                a.incluir(num);
            a.print();
            System.out.println("");
        }
    }
}
