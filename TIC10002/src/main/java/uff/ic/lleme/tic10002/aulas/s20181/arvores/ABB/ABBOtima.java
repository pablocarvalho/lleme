package uff.ic.lleme.tic10002.aulas.s20181.arvores.ABB;

import java.util.Arrays;
import uff.ic.lleme.tic10002.aulas.s20181.Objeto;

public class ABBOtima {

    private static double[] chaves = {0, 2, 4, 20, 36};
    private static double[] f1 = {0, 10, 1, 3, 2};
    private static double[] f2 = {2, 1, 1, 1, 1};
    private static double[][] c = new double[5][5];
    private static double[][] F = new double[5][5];
    private static int[][] K = new int[5][5];

    public static void main(String[] args) {
        calcularCusto();
        print(c);
        print(K);

        double[] chaves = ordenar(0, f1.length);
        ABB abb = new ABB();
        for (double c : chaves)
            abb.incluir(new Objeto(c));
        abb.print();
    }

    public static void calcularCustoDidatico1() {
        int n = c.length;

        for (int d = 1; d <= n; d++) {
            int j = 0;
            for (int i = 0; i <= n - d; i++) {
                j = i + d;
                System.out.println(String.format("c[%d][%d]", i, j));
            }
        }
    }

    public static void calcularCustoDidatico2() {
        int n = c.length;

        for (int j = 1; j <= n; j++) {
            c[j][j] = 0;
            F[j][j] = f2[j];
        }
    }

    public static void calcularCusto() {
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
                Custo menorCusto = menorCusto(i, j);
                c[i][j] = menorCusto.valor + F[i][j];
                K[i][j] = menorCusto.chave;

            }
        }
    }

    private static Custo menorCusto(int i, int j) {
        Double custoMinimo = Double.MAX_VALUE;
        Integer chaveDeMenorCusto = null;
        for (int k = i + 1; k <= j; k++)
            if (c[i][k - 1] + c[k][j] < custoMinimo) {
                custoMinimo = c[i][k - 1] + c[k][j];
                chaveDeMenorCusto = k;
            }
        return new Custo(custoMinimo, chaveDeMenorCusto);
    }

    private static double[] ordenar(int i, int j) {
        return ordenar(1, j, 0, new double[f1.length - 1]);
    }

    private static double[] ordenar(int i, int j, int ordem, double[] ordenacao) {
        if (i < j) {
            System.out.print(K[i][j] + " ");
            ordenacao[ordem] = K[i][j];
            ordenar(i, K[i][j] - 1, ordem++, ordenacao);
            ordenar(K[i][j], j, ordem++, ordenacao);
        }
        return ordenacao;
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
