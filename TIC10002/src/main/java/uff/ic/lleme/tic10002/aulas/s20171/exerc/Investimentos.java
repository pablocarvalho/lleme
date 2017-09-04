package uff.ic.lleme.tic10002.aulas.s20171.exerc;

public class Investimentos {

    public static void main(String[] args) {
        //                       J   F   M   A   M   J     J   A   S   O   N   D
        float[] aplicacoes = {100f, 0f, 0f, 10f, 0f, 0f, 100f, 0f, 0f, 0f, 0f, 0f};
        float j = 0.01f;

        float saldo = 0;
        for (int i = 0; i < aplicacoes.length; i++)
            saldo += aplicacoes[i] * Math.pow((1 + j), aplicacoes.length - i);

        System.out.println(String.format("O saldo final é %1$s", saldo));
    }
}
