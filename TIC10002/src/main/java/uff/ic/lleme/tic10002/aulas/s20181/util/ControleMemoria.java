package uff.ic.lleme.tic10002.aulas.s20181.util;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import uff.ic.lleme.tic10002.aulas.s20181.Objeto;

public class ControleMemoria {

    public static void main(String[] args) {
        Objeto[][] objetos = new Objeto[100][];
        System.out.println("Size = " + ObjectSizeCalculator.getObjectSize(objetos));

        for (int i = 0; i < objetos.length; i++) {
            int n = 1000;
            objetos[i] = new Objeto[n];
            for (int j = 0; j < n; j++)
                objetos[i][j] = new Objeto(1);
            System.out.println("Size = " + ObjectSizeCalculator.getObjectSize(objetos));
        }

    }
}
