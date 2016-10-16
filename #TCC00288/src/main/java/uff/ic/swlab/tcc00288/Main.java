package uff.ic.swlab.tcc00288;



public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task1());
        Thread t2 = new Thread(new Task2());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
