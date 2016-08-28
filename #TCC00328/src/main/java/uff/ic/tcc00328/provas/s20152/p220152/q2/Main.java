package uff.ic.tcc00328.provas.s20152.p220152.q2;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        double[][] data = new double[10000][3];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = Math.random() * 200 - 100;
            data[i][1] = Math.random() * 200 - 100;
        }
        Func func = new Func(data, 0, data.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(func);
        System.out.println("ok");
    }
}
