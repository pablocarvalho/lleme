package exercicios;

public class P120072Ex5 {

  public static void main(String[] args) {
    int n = 6;
    double soma = 0, x = Math.PI;
    for (int i = 0; i <= n; i++)
      soma += termo(i, x);
    System.out.println(soma);
  }

  public static double termo(int i, double x) {
    return (Math.pow(-1, i) / fat(2 * i)) * Math.pow(x, 2 * i);
  }

  public static int fat(int n) {
    int fatorial = 1;
    for (int i = 2; i <= n; i++)
      fatorial = fatorial * i;
    return fatorial;
  }
}
