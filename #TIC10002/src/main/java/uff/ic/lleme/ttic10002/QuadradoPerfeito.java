package uff.ic.lleme.ttic10002;

import java.util.Scanner;

public class QuadradoPerfeito {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número inteiro.");
        Integer num = sc.nextInt();

        if (ehQuadradoPerfeito(num))
            System.out.println(String.format("%1$d é um quadrado perfeito.", num));
        else
            System.out.println(String.format("%1$d não é um quadrado perfeito.", num));

    }

    public static boolean ehQuadradoPerfeito(Integer num) {
        int soma = 0;
        for (int i = 1; soma < num; i += 2)
            soma += i;
        if (soma == num)
            return true;
        else
            return false;
    }
}
