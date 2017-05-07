package uff.ic.tcc00175.patterns.templateMethod.app2;

import uff.ic.tcc00175.patterns.templateMethod.app1.AlgoritmoVersao1;
import uff.ic.tcc00175.patterns.templateMethod.framework.Algoritmo;

public class AlgoritmoVersao2 extends Algoritmo {

    public static void main(String[] args) {
        new AlgoritmoVersao1().executarAlgoritmo();
    }

    @Override
    protected void passo1() {
        System.out.println("passo 1 vers�o 2");
    }

    @Override
    protected void passo2() {
        System.out.println("passo 2 vers�o 2");
    }

    @Override
    protected void passo3() {
        System.out.println("passo 3 vers�o 2");
    }
}
