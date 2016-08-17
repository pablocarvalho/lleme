package exercicios;

public class P120102ex4v2 {

  public static void main(String[] args) {
    int cont = 0;
    int num = 2;
    while (cont < 4) {
      if (ePerfeito(num)) {
        System.out.println(num);
        cont++;
      }
      num++;
    }
  }

  public static boolean ePerfeito(int n) {
    int soma = 0;
    for (int div = n - 1; div >= 1; div--)
      if (n % div == 0)
        soma += div;
    if (soma == n)
      return true;
    return false;
  }
}