package uff.ic.lleme.tcc00328.aulas.concurrency;

import java.util.concurrent.RecursiveAction;

public class ForkMatriz extends RecursiveAction {

    private double[][] a, b, c;

    public ForkMatriz(double[][] a, double[][] b) {
        this.a = a;
        this.b = b;
    }

    @Override
    protected void compute() {
        int limite = 0;
        if (a.length * b[0].length > limite) {
            // divide
        } else
            multiplica();
    }

    private void multiplica() {
        c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < a[0].length; k++)
                    c[i][j] += a[i][k] * b[k][j];
    }
}
