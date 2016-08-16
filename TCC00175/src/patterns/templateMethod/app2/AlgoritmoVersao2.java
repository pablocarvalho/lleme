package patterns.templateMethod.app2;

import patterns.templateMethod.app1.AlgoritmoVersao1;
import patterns.templateMethod.framework.Algoritmo;

public class AlgoritmoVersao2 extends Algoritmo {

    public static void main(String[] args) {
        new AlgoritmoVersao1().executarAlgoritmo();
    }

    @Override
    protected void passo1() {
        System.out.println("passo 1 versão 2");
    }

    @Override
    protected void passo2() {
        System.out.println("passo 2 versão 2");
    }

    @Override
    protected void passo3() {
        System.out.println("passo 3 versão 2");
    }
}
