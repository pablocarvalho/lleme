package exercicios;

public class P120102Ex4 {

  public static void main(String[] args) {
    int contador = 0, n = 2;
    boolean teste;
    do {
      teste = ePerfeito(n);
      if (teste) {
        System.out.println(n);
        contador++;
      }
      n++;
    } while (contador < 5);
  }

  public static boolean ePerfeito(int n) {
    int soma = 0;
    for (int i = 1; i < n; i++)
      if (n % i == 0)
        soma += i;
    if (soma == n)
      return true;
    return false;
  }
}
