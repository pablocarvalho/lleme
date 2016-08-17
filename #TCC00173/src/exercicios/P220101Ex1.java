package exercicios;

public class P220101Ex1 {

  public static float produtoInterno(float[] x, float[] y) {
    float soma = 0.0f;
    for (int cont = 0; cont < x.length; cont++)
      soma += x[cont] * y[cont];
    return soma;
  }

  public static void main(String[] args) {
    float x[] = {2.3f, 4.5f, 6.7f};
    float y[] = {2.3f, 4.5f, 6.7f};
    System.out.println(produtoInterno(x, y));
  }
}
