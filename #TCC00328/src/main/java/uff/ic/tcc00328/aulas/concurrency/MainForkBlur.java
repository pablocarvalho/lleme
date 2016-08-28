package uff.ic.tcc00328.aulas.concurrency;

import java.util.concurrent.ForkJoinPool;

public class MainForkBlur {

    public static void main(String[] args) {
        int[] src = null;
        int[] dst = null;
        // source image pixels are in src
        // destination image pixels are in dst
        ForkBlur fb = new ForkBlur(src, 0, src.length, dst);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(fb);
    }
}
