package exercicios;

public class P120111Ex1 {

  public static void main(String[] args) {
    System.out.println(mmc(15, 24));
  }

  public static int mmc(int a, int b) {
    int mmc = 1;
    int div = 2;
    while (a > 1 || b > 1)
      if (a % div == 0 && b % div == 0) {
        a /= div;
        b /= div;
        mmc *= div;
      } else if (a % div == 0) {
        a /= div;
        mmc *= div;
      } else if (b % div == 0) {
        b /= div;
        mmc *= div;
      } else if (div == 2)
        div++;
      else
        div += 2;

    return mmc;

  }
}
