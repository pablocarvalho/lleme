package uff.ic.lleme.tic10002.aulas._old.s20172.arvoreAvl;

public class Main {

    public static void main(String[] args) {
        exemplo2();
    }

    public static void exemplo1() {
        int[] chaves = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        double[] f = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        double[] f2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        ABBOtima abbOtima = new ABBOtima(chaves, f, f2);
        abbOtima.printOrdemIndices();
        abbOtima.printOrdemChaves();
        abbOtima.printCusto();
        abbOtima.arvore.print();
    }

    public static void exemplo2() {
        int[] chaves = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        double[] f = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        double[] f2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        ABBOtima abbOtima = new ABBOtima(chaves, f, f2);
        abbOtima.printOrdemIndices();
        abbOtima.printOrdemChaves();
        abbOtima.printCusto();
        abbOtima.arvore.print();
    }
}
