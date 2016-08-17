package exemplos;

public class PI {

  public static void main(String[] args) {
    //System.out.println(pi(100));
    //System.out.println(prodImpares(1));
    divisores(14);
  }

  public static double pi(int n) {
    double soma = 0;
    for (int i = 0; i < 10000000; i++)
      soma = soma + Math.pow(-1, i) / (2 * i + 1);
    return 4 * soma;
  }

  public static int prodImpares(int n) {
    int produto = 1;
    int cont = 2;
    for (int i = 3; cont <= n; i += 2) {
      produto = produto * i;
      cont++;
    }
    return produto;
  }

  public static void divisores(int n) {
    int divisorCandidato = 1;
    while (divisorCandidato <= n) {
      if (n % divisorCandidato == 0)
        System.out.println(divisorCandidato);
      divisorCandidato++;
    }
  }
}
