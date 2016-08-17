package aulas.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Collections {

    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger(2);
        System.out.println(num.get());
        System.out.println(num.incrementAndGet());

    }
}
