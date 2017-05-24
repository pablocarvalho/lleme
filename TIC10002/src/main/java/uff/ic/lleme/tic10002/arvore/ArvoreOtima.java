package uff.ic.lleme.tic10002.arvore;

import java.util.Arrays;

public class ArvoreOtima {

    private static double[] f = {0, 10, 1, 3, 2};
    private static double[] f2 = {2, 1, 1, 1, 1};

    private static double[][] F = new double[f2.length][f2.length];
    private static double[][] c = new double[f2.length][f2.length];
    private static int[][] K = new int[f2.length][f2.length];

    public static void main(String[] args) {
        custo(f, f2);
        print(c);
        print(K);
        print(ordem());
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

    private static int[] ordem() {
        int n = c.length - 1;
        int[] ordem = new int[n];
        int[] seq = new int[1];
        busca(ordem, seq, 0, n);
        return ordem;
    }

    public static void busca(int[] o, int[] s, int i, int j) {
        if (j > i + 1 && i >= 0 && j >= 0 && i < c.length && j < c.length && s[0] < K.length - 1) {
            int chave = K[i][j];
            o[s[0]] = chave;
            s[0]++;
            busca(o, s, i - 1, chave);
            busca(o, s, chave, j);
        }
    }

    public static void print(int[] c) {
        System.out.println(Arrays.toString(c).replaceAll(" ", "\t"));
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
