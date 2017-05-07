package uff.ic.tcc00175.patterns.templateMethod.app1;

import uff.ic.tcc00175.patterns.templateMethod.framework.Algoritmo;

public class AlgoritmoVersao1 extends Algoritmo {

    public static void main(String[] args) {
        new AlgoritmoVersao1().executarAlgoritmo();
    }

    @Override
    protected void passo1() {
        System.out.println("passo 1 vers�o 1");
    }

    @Override
    protected void passo2() {
        System.out.println("passo 2 vers�o 1");
    }

    @Override
    protected void passo3() {
        System.out.println("passo 3 vers�o 1");
    }
}
