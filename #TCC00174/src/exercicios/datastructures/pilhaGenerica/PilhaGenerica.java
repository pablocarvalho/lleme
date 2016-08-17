package exercicios.datastructures.pilhaGenerica;

import java.util.Scanner;

public class PilhaGenerica {

  public static final void main(String[] args) {

    Pilha<Double> p1 = new Pilha<Double>(10);
    Pilha<String> p2 = new Pilha<String>(10);

    Scanner s = new Scanner(System.in);

    System.out.println("Digite valores reais positivos.");
    System.out.println("Digite um negativo para terminar");

    Double d = s.nextDouble();

    while (d >= 0) {
      p1.push(d);
      d = s.nextDouble();
    }

    while (!p1.vazia())
      System.out.println(p1.pop());

    System.out.println("Digite uma palavra.");
    System.out.println("Digite fim para terminar");



    String str = s.next();

    while (str.compareTo("fim") != 0) {
      p2.push(str);
      str = s.next();
    }

    while (!p2.vazia())
      System.out.println(p2.pop());


  }
}
