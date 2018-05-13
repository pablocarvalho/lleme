package uff.ic.lleme.tic10002.aulas.s20181.arvores.ABB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uff.ic.lleme.tic10002.aulas.s20181.Conteudo;

public class ABBOtima {

    private static double[] chaves = {0, 2, 4, 20, 36};
    private static List<Integer> ordenacao = new ArrayList<>();
    private static double[] f = {0, 10, 1, 3, 2};
    private static double[] fl = {2, 1, 1, 1, 1};
    private static double[][] c = new double[5][5];
    private static double[][] F = new double[5][5];
    private static int[][] K = new int[5][5];

    public static void main(String[] args) {
        calcularCusto();
        ordenarChaves(0, f.length - 1);

        print(c);
        print(K);
        print(ordenacao);

        ABB abb = new ABB();
        for (int c : ordenacao)
            abb.incluir(new Conteudo(chaves[c]));
        abb.print();
    }

    private static void print(List<Integer> ordenacao) {
        System.out.println(ordenacao.toString() + "\n");
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
            F[j][j] = fl[j];
        }
    }

    public static void calcularCusto() {
        int n = c.length - 1;

        for (int j = 0; j < n; j++) {
            c[j][j] = 0;
            F[j][j] = fl[j];
        }

        for (int d = 1; d <= n; d++) {
            int j = 0;

            for (int i = 0; i <= n - d; i++) {
                j = i + d;

                F[i][j] = F[i][j - 1] + f[j] + fl[j];
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

    private static void ordenarChaves(int i, int j) {
        if (i < j) {
            ordenacao.add(K[i][j]);
            ordenarChaves(i, K[i][j] - 1);
            ordenarChaves(K[i][j], j);
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
