package provas.s20111;

import java.util.Scanner;

public class P220111Ex1 {

  public static void main(String[] args) {
    int tamanhoBarra = 11;
    Scanner in = new Scanner(System.in);
    float metragem = in.nextFloat();
    int qtd = (int) (metragem / tamanhoBarra);
    if ((qtd * tamanhoBarra) < metragem)
      qtd++;
    System.out.println(qtd);
  }
}
