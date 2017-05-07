package uff.ic.tcc00328.provas.s20152.p220152.q2;

import java.util.concurrent.RecursiveAction;

public class Func extends RecursiveAction {

    public double[][] data;
    public int i, j;

    public Func(double[][] data, int i, int j) {
        this.data = data;
        this.i = i;
        this.j = j;
    }

    public void compute_directly() {
        for (int k = i; k < j; k++) {
            data[k][2] += Math.pow(3 * data[k][0], 2);
            data[k][2] += Math.pow(6 * data[k][0], 2);
            data[k][2] += 3 * data[k][0] * data[k][1];
            data[k][2] += 2 * data[k][0];
            data[k][2] += data[k][1];
        }
    }

    @Override
    protected void compute() {
        if (j - i < 1000)
            compute_directly();
        else
            invokeAll(new Func(data, i, (i + j) / 2), new Func(data, (i + j) / 2, j));
    }
}
