package uff.ic.lleme.ttic10002.exerc;

import java.util.Scanner;

public class Lista1Ex1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // k1
        System.out.println("Digite um numero."); // k2
        int num = sc.nextInt(); // k3

        int soma = 0; // k4
        int apoio = 1; // k5

        while (soma < num) {
            soma += apoio; // k6
            apoio += 2; // k7
        }

        if (soma == num) // k8
            System.out.println("É perfeito"); //k9
        else
            System.out.println("Não é perfeito");
    }
}
