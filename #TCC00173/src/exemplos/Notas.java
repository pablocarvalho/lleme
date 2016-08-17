package exemplos;

import java.util.Scanner;

public class Notas {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int valor, cem, cinquenta, vinte, dez, cinco, dois, um;
    System.out.println("Entre com um valor em Reais: ");
    valor = in.nextInt();

    cem = valor / 100;
    valor = valor % 100;
    cinquenta = valor / 50;
    valor = valor % 50;
    vinte = valor / 20;
    valor = valor % 20;
    dez = valor / 10;
    valor = valor % 10;
    cinco = valor / 5;
    valor = valor % 5;
    dois = valor / 2;
    um = valor % 2;

    System.out.println("CEM: " + cem + " \nCINQUENTA: " + cinquenta + " \nVINTE: "
            + vinte + " \nDEZ " + dez + " \nCINCO " + cinco + " \nDOIS " + dois
            + " \nUM " + um);
  }
}
