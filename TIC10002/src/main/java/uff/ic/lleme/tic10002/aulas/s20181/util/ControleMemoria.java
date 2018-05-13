package uff.ic.lleme.tic10002.aulas.s20181.util;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import uff.ic.lleme.tic10002.aulas.s20181.Conteudo;

public class ControleMemoria {

    public static void main(String[] args) {
        Conteudo[][] objetos = new Conteudo[100][];
        System.out.println("Size = " + ObjectSizeCalculator.getObjectSize(objetos));

        for (int i = 0; i < objetos.length; i++) {
            int n = 1000;
            objetos[i] = new Conteudo[n];
            for (int j = 0; j < n; j++)
                objetos[i][j] = new Conteudo(1);
            System.out.println("Size = " + ObjectSizeCalculator.getObjectSize(objetos));
        }

    }
}
