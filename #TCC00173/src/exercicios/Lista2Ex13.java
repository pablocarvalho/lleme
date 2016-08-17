package exercicios;

public class Lista2Ex13 {

  public static void main(String[] args) {

    for (int n = 1; n < 10000; n++)
      System.out.println(pi(n));

  }

  public static double pi(int n) {
    int denominador = 1;
    double termo = 0;
    double soma = 0;
    for (int i = 0; i < n; i++) {
      termo = ((int) Math.pow(-1, i)) * 1.0f / denominador;
      soma += termo;
      denominador += 2;
    }
    double pi = 4 * soma;
    return pi;
  }
}
