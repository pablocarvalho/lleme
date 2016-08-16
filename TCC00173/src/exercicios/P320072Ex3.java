package exercicios;

import exemplos.oo.ponto.Ponto;

public class P320072Ex3 {

  public static void main(String[] args) {
    Ponto[] vertices = {new Ponto(1, 2), new Ponto(3, 4), new Ponto(2, 5)};
    poligono(vertices);
  }

  public static void poligono(Ponto[] vertices) {
    for (int i = 1; i <= vertices.length - 2; i++) {
      if (i == 1)
        System.out.println("imprime linha (" + vertices[0].x + "," + vertices[0].y + ")-(" + vertices[i].x + "," + vertices[i].y + ")");
      System.out.println("imprime linha (" + vertices[i].x + "," + vertices[i].y + ")-(" + vertices[i + 1].x + "," + vertices[i + 1].y + ")");

      if (i + 1 == vertices.length - 1)
        System.out.println("imprime linha (" + vertices[i + 1].x + "," + vertices[i + 1].y + ")-(" + vertices[0].x + "," + vertices[0].y + ")");
    }


  }
}
