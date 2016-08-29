package uff.ic.tcc00175.oo.palindromo;

import java.util.Collection;
import java.util.Scanner;

public class Palindromo {

    public static void main(String[] args) {
        System.out.println("Escreva um texto:");
        Scanner scanner = new Scanner(System.in);
        Texto texto = new Texto(scanner.nextLine());
        System.out.println("O texto \"" + texto.toString() + "\" "
                + (texto.isPalindromo() ? "�" : "n�o �")
                + " palindromo");
    }
}
