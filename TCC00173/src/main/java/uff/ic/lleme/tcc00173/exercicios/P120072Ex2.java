/*
 * Escreva um programa para calcular a �rea sob a curva de uma fun��o definida
 * por uma linha poligonal (�rea sombreada na figura abaixo). A linha poligonal
 * � definida por meio de um conjunto de pontos no gr�fico cartesiano em ordem
 * crescente de abscissas. A �rea pode ser calculada da seguinte forma:
 *
 * Segmentos em que a linha poligonal corta o eixo das abscissas:
 * Delta=xi-xi-1
 * bi=|yi|Delta/(|yi|+|yi-1|)
 * bi-1=Delta-bi
 * A=(|yi|bi+|yi-1|bi-1)/2
 *
 * Segmentos em que a poligonal n�o corta o eixo X.
 * Delta=xi-xi-1
 * A=Delta*menor(|yi|,|yi-1|)+Delta*|yi-yi-1|/2
 *
 */
package uff.ic.lleme.tcc00173.exercicios;

import java.util.Scanner;

public class P120072Ex2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int i, n;
    double x_1, y_1, x, y, area;

    System.out.println("Informe numero de pontos: ");
    n = in.nextInt();

    area = 0;
    System.out.println("Ponto 1: ");
    x_1 = in.nextDouble();
    y_1 = in.nextDouble();

    for (i = 2; i <= n; i++) {

      do {
        System.out.println("Ponto " + i);
        x = in.nextDouble();
        y = in.nextDouble();
        if (x <= x_1)
          System.out.println("Coordenada invalida");
      } while (x <= x_1);

      if (corta(x_1, y_1, x, y))
        area = area + a1(x_1, y_1, x, y);
      else
        area = area + a2(x_1, y_1, x, y);

      x_1 = x;
      y_1 = y;
    }
    System.out.println("Area = " + area);

  }

  public static boolean corta(double x1, double y1, double x2, double y2) {
    if (y1 * y2 < 0)
      return true;
    return false;
  }

  public static double menor(double n1, double n2) {
    if (n1 > n2)
      return n2;
    return n1;
  }

  public static double deltaDif(double n1, double n2) {
    return Math.abs(n1 - n2);
  }

  public static double bi(double x1, double y1, double x2, double y2) {
    if (Math.abs(y1) + Math.abs(y2) != 0)
      return Math.abs(y2) * deltaDif(x1, x2) / (Math.abs(y1) + Math.abs(y2));
    return 0;
  }

  public static double bi_1(double x1, double y1, double x2, double y2) {
    return deltaDif(x1, x2) - bi(x1, y1, x2, y2);
  }

  public static double a1(double x1, double y1, double x2, double y2) {
    return (Math.abs(y2) * bi(x1, y1, x2, y2) + Math.abs(y1) * bi_1(x1, y1, x2, y2)) / 2;
  }

  public static double a2(double x1, double y1, double x2, double y2) {
    return deltaDif(x1, x2) * menor(Math.abs(y1), Math.abs(y2)) + deltaDif(x1, x2) * Math.abs(y1 - y2) / 2;
  }
}
