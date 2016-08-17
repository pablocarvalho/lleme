package provas.s20112;

public class P120112Ex1 {

  public static void main(String[] args) {

    int[] numeros = {13, 15, 24};
    System.out.println(mmc(numeros));

  }

  public static int mmc(int[] numeros) {
    int mmc = 1;
    int div = 2;
    boolean houveFatoracao;
    while (houverNumeroParaFatorar(numeros)) {
      houveFatoracao = fatorarNumeros(numeros, div);
      if (houveFatoracao)
        mmc *= div;
      else if (div == 2)
        div++;
      else
        div += 2;
    }
    return mmc;

  }

  public static boolean houverNumeroParaFatorar(int[] numeros) {
    for (int numero : numeros)
      if (numero > 1)
        return true;
    return false;
  }

  private static boolean fatorarNumeros(int[] numeros, int div) {
    boolean hoveFatoracao = false;
    for (int i = 0; i < numeros.length; i++)
      if (numeros[i] % div == 0) {
        numeros[i] /= div;
        hoveFatoracao = true;
      }
    return hoveFatoracao;
  }
}
