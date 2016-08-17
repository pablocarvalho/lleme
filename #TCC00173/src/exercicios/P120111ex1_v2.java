package exercicios;

public class P120111ex1_v2 {

  public static void main(String[] args) {
    int n1 = 15;
    int n2 = 24;
    int fator = 2;
    int mmc = 1;
    while (n1 > 1 || n2 > 1)
      if (alguemForDivisivel(n1, n2, fator)) {
        n1 = tentaDividir(n1, fator);
        n2 = tentaDividir(n2, fator);
        mmc *= fator;
      } else
        fator = proximoFator(fator);
    System.out.println(mmc);
  }

  private static boolean alguemForDivisivel(int n1, int n2, int fator) {
    if (n1 % fator == 0 || n2 % fator == 0)
      return true;
    return false;
  }

  private static int tentaDividir(int n, int fator) {
    if (n % fator == 0)
      n /= fator;
    return n;
  }

  private static int proximoFator(int fator) {
    if (fator == 2)
      fator += 1;
    else
      fator += 2;
    return fator;
  }
}