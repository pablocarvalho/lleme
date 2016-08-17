package exercicios;

public class P120112Ex1 {

  public static void main(String[] args) {
    int[] numeros = {13, 15, 24};
    System.out.println(mmc(numeros));
  }

  public static int mmc(int[] numeros) {
    int mmc = 1;
    int divisor = 2;
    boolean conseguiDividir = false;
    while (existeNumero(numeros)) {
      conseguiDividir = fatora(numeros, divisor);
      if (!conseguiDividir)
        if (divisor == 2)
          divisor++;
        else
          divisor += 2;
      else
        mmc *= divisor;
    }
    return mmc;
  }

  private static boolean existeNumero(int[] numeros) {
    for (int i = 0; i < numeros.length; i++)
      if (numeros[i] != 1)
        return true;
    return false;
  }

  private static boolean fatora(int[] numeros, int divisor) {
    boolean consegui = false;
    for (int i = 0; i < numeros.length; i++)
      if (numeros[i] % divisor == 0) {
        numeros[i] /= divisor;
        consegui = true;
      }
    return consegui;
  }
}
