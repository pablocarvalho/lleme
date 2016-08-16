package oo.tabuada;

public class Fator {

    /**
     * @attribute
     */
    protected byte fator;

    public Fator(byte fator) {
        this.fator = fator;
    }

    public void excrever(int linha) {
        System.out.print("" + fator + " * " + linha + " = " + (fator * linha));
    }
}
