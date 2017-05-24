package uff.ic.lleme.tic10002.arvore;

public class ArvoreOtima2 {

    private static double[] f = {0, 10, 1, 3, 2};
    private static double[] f2 = {2, 1, 1, 1, 1};

    private static double[][] F = new double[f2.length][f2.length];
    private static double[][] c = new double[f2.length][f2.length];
    private static int[][] K = new int[f2.length][f2.length];

    public static void main(String[] args) {
        int n = f.length - 1;
        System.out.println("" + custo(0, n));
    }

    public static double custo(int i, int j) {
        for (int k = 0; k < f.length; k++) {
            c[k][k] = 0;
            F[k][k] = f2[k];
        }

        c(1, 2) =  ?
                ? c(2, 3) =  ?  ?

        return 0.0;
    }

}
