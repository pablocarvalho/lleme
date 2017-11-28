package uff.ic.lleme.tic10002.provas.s20172.P120172Q4;

import java.util.Arrays;

public class ABBOtima {

    private static int[] chaves = {0, 2, 3, 12, 37, 56};
    private static double[] f = {0, 1, 2, 3, 2, 2};
    private static double[] f2 = {0, 1, 0, 2, 1, 0};

    private static double[][] F = new double[f2.length][f2.length];
    private static double[][] c = new double[f2.length][f2.length];
    private static int[][] K = new int[f2.length][f2.length];

    public static void main(String[] args) {
        custo(f, f2);
        print(c, K);

        int[] ordem = ordem();
        print(ordem);

        int[] ch = new int[chaves.length - 1];
        for (int i = 0; i < ordem.length; i++)
            ch[i] = chaves[ordem[i]];
        print(ch);

        System.out.println("");
        ABB a = new ABB();
        for (int i : ordem)
            a.incluir(chaves[i]);
        a.print();
    }

    public static double custo(double[] f, double[] f2) {
        int n = f2.length - 1;

        for (int j = 0; j < f2.length; j++) {
            c[j][j] = 0;
            F[j][j] = f2[j];
        }

        int j;
        for (int d = 1; d <= n; d++)
            for (int i = 0; i <= n - d; i++) {
                j = i + d;
                F[i][j] = F[i][j - 1] + f[j] + f2[j];
                c[i][j] = min(i, j) + F[i][j];
            }
        return c[0][n];
    }

    public static double min(int i, int j) {
        double soma, min = Double.MAX_VALUE;
        for (int k = i + 1; k <= j; k++) {
            soma = c[i][k - 1] + c[k][j];
            if (soma < min) {
                min = soma;
                K[i][j] = k;
            }
        }
        return min;
    }

    private static class Ordem {

        public int[] o = null;
        public int index = 0;

        public Ordem(int tamanho) {
            this.o = new int[tamanho];
        }

        public void insert(int elemento) {
            o[index++] = elemento;
        }
    }

    private static int[] ordem() {
        int n = c.length - 1;
        Ordem ordem = new Ordem(n);
        busca(0, n, ordem);
        return ordem.o;
    }

    public static void busca(int i, int j, Ordem o) {
        if (j >= i + 1 && i >= 0 && j >= 0 && i < K.length && j < K.length) {
            int pos = K[i][j];
            o.insert(pos);
            busca(i, pos - 1, o);
            busca(pos, j, o);
        }
    }

    public static void print(int[] c) {
        System.out.println(Arrays.toString(c).replaceAll(" ", "\t"));
        System.out.println("");
    }

    public static void print(double[][] c, int[][] k) {
        String[][] s = new String[c.length][c[0].length];
        for (int i = 0; i < k.length; i++)
            for (int j = 0; j < k.length; j++)
                if (j > i)
                    s[i][j] = c[i][j] + "/" + k[i][j];
                else
                    s[i][j] = c[i][j] + "";
        for (String[] s1 : s)
            System.out.println(Arrays.toString(s1).replaceAll(" ", "\t"));
        System.out.println("");
    }

    public static void print(double[][] c) {
        for (double[] c1 : c)
            System.out.println(Arrays.toString(c1).replaceAll(" ", "\t"));
        System.out.println("");
    }

    public static void print(int[][] c) {
        for (int[] c1 : c)
            System.out.println(Arrays.toString(c1).replaceAll(" ", "\t"));
        System.out.println("");
    }

}
