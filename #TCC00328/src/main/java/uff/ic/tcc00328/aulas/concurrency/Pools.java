package uff.ic.tcc00328.aulas.concurrency;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Pools {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(10);
        Executors.newSingleThreadExecutor();
        Executors.newSingleThreadScheduledExecutor();
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Future<?> f1 = pool.submit((Runnable) null);
        List<Future<?>> list = null;
        while (!list.isEmpty())
            for (Future<?> f : list)
                if (f.isDone()) {
                    Object o = f.get();
                    list.remove(f);
                }
    }
}
