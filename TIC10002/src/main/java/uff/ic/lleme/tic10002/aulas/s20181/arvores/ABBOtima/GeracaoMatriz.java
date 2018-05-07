package uff.ic.lleme.tic10002.aulas.s20181.arvores.ABBOtima;

import java.util.Arrays;

public class GeracaoMatriz {

    public static void main(String[] args) {
        m3();

    }

    public static void m1() {
        double[][] c = new double[5][5];
        double[][] F = new double[5][5];
        double[] f1 = {0, 10, 1, 3, 2};
        double[] f2 = {2, 1, 1, 1, 1};

        int n = c.length;

        for (int d = 1; d <= n; d++) {
            int j = 0;
            for (int i = 0; i <= n - d; i++) {
                j = i + d;
                System.out.println(String.format("c[%d][%d]", i, j));
            }
        }

    }

    public static void m2() {
        double[][] c = new double[5][5];
        double[][] F = new double[5][5];
        double[] f1 = {0, 10, 1, 3, 2};
        double[] f2 = {2, 1, 1, 1, 1};

        int n = c.length;

        for (int j = 1; j <= n; j++) {
            c[j][j] = 0;
            F[j][j] = f2[j];
        }

    }

    public static void m3() {
        double[][] c = new double[5][5];
        double[][] F = new double[5][5];
        int[][] K = new int[5][5];
        double[] f1 = {0, 10, 1, 3, 2};
        double[] f2 = {2, 1, 1, 1, 1};

        int n = c.length - 1;

        for (int j = 0; j < n; j++) {
            c[j][j] = 0;
            F[j][j] = f2[j];
        }

        for (int d = 1; d <= n; d++) {
            int j = 0;

            for (int i = 0; i <= n - d; i++) {
                j = i + d;

                F[i][j] = F[i][j - 1] + f1[j] + f2[j];
                Custo menorCusto = menorCusto(i, j, c);
                c[i][j] = menorCusto.valor + F[i][j];
                K[i][j] = menorCusto.chave;

            }
        }
        print(c);
        print(K);
        ordem(0, n, K);

    }

    private static Custo menorCusto(int i, int j, double[][] c) {
        Double custoMinimo = Double.MAX_VALUE;
        Integer chaveDeMenorCusto = null;
        for (int k = i + 1; k <= j; k++)
            if (c[i][k - 1] + c[k][j] < custoMinimo) {
                custoMinimo = c[i][k - 1] + c[k][j];
                chaveDeMenorCusto = k;
            }
        return new Custo(custoMinimo, chaveDeMenorCusto);
    }

    private static void ordem(int i, int j, int[][] K) {
        if (i < j) {
            System.out.print(K[i][j] + " ");
            ordem(i, K[i][j] - 1, K);
            ordem(K[i][j], j, K);
        }
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
