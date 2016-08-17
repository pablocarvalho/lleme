package exercicios;

public class P120111Ex1_2 {

  public static void main(String[] args) {
    int n1 = 15, n2 = 24, fator = 2, mmc = 1;

    while (n1 > 1 || n2 > 1) {
      while (n1 % fator == 0 || n2 % fator == 0) {
        if (n1 % fator == 0)
          n1 /= fator;
        if (n2 % fator == 0)
          n2 /= fator;
        mmc *= fator;
      }
      fator = (fator % 2 == 0) ? fator + 1 : fator + 2;
    }
    System.out.println(mmc);

    boolean decola;
  }

  public static boolean primo(int x) {
    if (x < 2)
      return false;
    int div = 2;
    while (div <= Math.sqrt(x))
      if (x % div == 0)
        return false;
      else
        div = div % 2 == 0 ? div + 1 : div + 2;
    return true;
  }
}
