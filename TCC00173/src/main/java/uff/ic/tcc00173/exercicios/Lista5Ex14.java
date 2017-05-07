package uff.ic.tcc00173.exercicios;

import java.util.Scanner;

public class Lista5Ex14 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int xa, xb, xc, ya, yb, yc;
    xa = in.nextInt();
    ya = in.nextInt();
    xb = in.nextInt();
    yb = in.nextInt();
    xc = in.nextInt();
    yc = in.nextInt();
    if (estaDentroRetangulo(xa, xb, ya, yb, xc, yc))
      System.out.println("o ponto est� dentro do ret�ngulo");
    else
      System.out.println("o ponto n�o est� dentro do ret�ngulo");
  }

  public static boolean estaDentroRetangulo(int xa, int xb, int ya, int yb, int xc, int yc) {
    if (xa <= xc && xc <= xb && ya <= yc && yc <= yb)
      return true;
    return false;
  }
}
