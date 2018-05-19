package uff.ic.lleme.tic10002.aulas.s20171.hashing;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import uff.ic.lleme.tic10002.utils.Empregado;

public class HashingLinear {

    public static void main(String[] args) {
        Empregado[][] empregados = new Empregado[100][];
        System.out.println("Size = " + ObjectSizeCalculator.getObjectSize(empregados));

        Empregado e1 = new Empregado(1);
        Empregado e2 = new Empregado(1);
        Empregado e3 = new Empregado(1);
        Empregado e4 = new Empregado(1);
        Empregado e5 = new Empregado(1);
        Empregado[] linha = {e1, e2, e3, e4, e5};
        empregados[0] = linha;
        System.out.println("Size = " + ObjectSizeCalculator.getObjectSize(empregados));

        Empregado e6 = new Empregado(1);
        Empregado e7 = new Empregado(1);
        Empregado e8 = new Empregado(1);
        Empregado e9 = new Empregado(1);
        Empregado e10 = new Empregado(1);
        Empregado[] linha2 = {e6, e7, e8, e9, e10};
        empregados[1] = linha2;
        System.out.println("Size = " + ObjectSizeCalculator.getObjectSize(empregados));

    }
}
