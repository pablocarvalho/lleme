package uff.ic.lleme.tic10002.trabalhos.s20171.danielbastos;

public class Montante {

    int key;
    double total;

    public Montante(int k, double t) {
        key = k;
        total = t;
    }

    @Override
    public String toString() {
        String ret = String.format("Montante(date: %d total: %.2f)",
                key, total);
        return ret;
    }

}
