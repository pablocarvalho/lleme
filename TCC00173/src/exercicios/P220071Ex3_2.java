package exercicios;

public class P220071Ex3_2 {

  public static void main(String[] args) {
    float limiteInferior = 0;
    float limiteSuperior = 100;
    int numeroIntervalos = 100;
    System.out.println(integral(limiteInferior, limiteSuperior,
            numeroIntervalos));

  }

  public static float f(float x) {
    return 0;
  }

  public static float integral(float li, float ls, int n) {
    float xi, soma = 0;
    for (int i = 0; i < n; i++) {
      xi = li + i * (ls - li) / n;
      soma += f(xi) * (ls - li) / n;
    }
    return soma;
  }
}
