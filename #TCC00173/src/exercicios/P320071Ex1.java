package exercicios;

public class P320071Ex1 {

  public static void main(String[] args) {
    float vetor[] = {3.0f, 2.0f, 1.0f};

  }

  public static boolean eh_raiz(float[] a, float xr) {
    float acumulador = 0;
    for (int i = 0; i < a.length; i++)
      acumulador += a[i] * Math.pow(xr, i);

    if (Math.abs(acumulador) <= 1E-5)
      return true;
    return false;
  }
}
