package provas.s20102;

public class P120102Ex4 {

  public static void main(String[] args) {
    int n = 3, contador = 0;
    while (contador < 4) {
      if (ePerfeito(n)) {
        System.out.println(n);
        contador++;
      }
      n++;
    }
  }

  public static boolean ePerfeito(int n) {
    int soma = 1;
    for (int i = 2; i <= n / 2; i++)
      if ((n % i) == 0)
        soma = soma + i;
    if (soma == n)
      return true;
    return false;
  }
}
