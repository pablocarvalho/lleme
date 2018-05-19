package uff.ic.lleme.tic10002.aulas.old.s20172.arvoreAvl;

import java.util.Arrays;

public class ABBOtima {

    public int[] chaves;
    public double[] f;
    public double[] f2;

    public double[][] F;
    public double[][] c;
    public int[][] k;

    public int[] ordemIndices;
    public int[] ordemChaves;
    public ABB arvore;

    public ABBOtima(int[] chaves, double[] f, double[] f2) {
        this.chaves = chaves;
        this.f = f;
        this.f2 = f2;

        F = new double[f2.length][f2.length];
        c = new double[f2.length][f2.length];
        k = new int[f2.length][f2.length];

        custo();
        ordemIndices();
        ordemChaves();
        arvore = new ABB();
        for (int i : ordemChaves)
            arvore.incluir(i);
    }

    private double custo() {
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

    private double min(int i, int j) {
        double soma, min = Double.MAX_VALUE;
        for (int k = i + 1; k <= j; k++) {
            soma = c[i][k - 1] + c[k][j];
            if (soma <= min) {
                min = soma;
                this.k[i][j] = k;
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

    private void ordemIndices() {
        int n = c.length - 1;
        Ordem ordem = new Ordem(n);
        ordemIndices(0, n, ordem);
        ordemIndices = ordem.o;
    }

    private void ordemIndices(int i, int j, Ordem o) {
        if (j >= i + 1 && i >= 0 && j >= 0 && i < k.length && j < k.length) {
            int pos = k[i][j];
            o.insert(pos - 1);
            ordemIndices(i, pos - 1, o);
            ordemIndices(pos, j, o);
        }
    }

    private void ordemChaves() {
        int[] ch = new int[chaves.length];
        for (int i = 0; i < ordemIndices.length; i++)
            ch[i] = chaves[ordemIndices[i]];
        ordemChaves = ch;
    }

    public void printOrdemChaves() {
        System.out.println(Arrays.toString(ordemChaves).replaceAll(" ", "\t"));
        System.out.println("");
    }

    public void printOrdemIndices() {
        System.out.println(Arrays.toString(ordemIndices).replaceAll(" ", "\t"));
        System.out.println("");
    }

    public void printCusto() {
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

}
