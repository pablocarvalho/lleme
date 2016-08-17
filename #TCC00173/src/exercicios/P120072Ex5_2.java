package exercicios;

public class P120072Ex5_2 {

  public static void main(String[] args) {

    for (int i = 0; i < 20; i++)
      System.out.println("i=" + i + " -> " + cosseno(Math.PI, i));


  }

  public static double cosseno(double x, int n) {
    double cosseno = 0;
    for (int i = 0; i < n; i++)
      cosseno = cosseno + Math.pow(-1, i) * Math.pow(x, 2 * i) / fatorial(
              2 * i);
    return cosseno;
  }

  public static int fatorial(int n) {
    int fatorial = 1;
    for (int fat = 1; fat <= n; fat++)
      fatorial *= fat;
    return fatorial;
  }
}