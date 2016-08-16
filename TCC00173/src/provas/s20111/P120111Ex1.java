package provas.s20111;

public class P120111Ex1 {

  public static void main(String[] args) {
    System.out.println(mmc(15, 24));
  }

  public static int mmc(int n1, int n2) {
    int fator = 2;
    int mmc = 1;
    while (n1 > 1 || n2 > 1) {
      while (n1 % fator == 0 || n2 % fator == 0) {
        //if (n1 % fator == 0 || n2 % fator == 0)
        mmc = mmc * fator;
        if (n1 % fator == 0)
          n1 /= fator;
        if (n2 % fator == 0)
          n2 /= fator;
      }
      fator++;
    }
    return mmc;
  }

  public static int proximoPrimo(int n) {
    n += 1;
    while (!primo(n))
      n++;
    return n;
  }

  public static boolean primo(int n) {
    n = Math.abs(n);
    if (n == 2)
      return true;
    else if (n == 1 || n % 2 == 0)
      return false;
    else
      for (int i = 3; i < Math.sqrt(n); i += 2)
        if (n % i == 0)
          return false;
    return true;
  }
}
