package exercicios;

public class P320071Ex1_2 {

  public static void main(String[] args) {
    float[] a = {-4, 0, 1};
    float xr = 3;
    System.out.println(eh_raiz(a, xr));
  }

  public static boolean eh_raiz(float a[], float xr) {
    float resultado = 0;
    for (int i = 0; i < a.length; i++)
      resultado += (float) (a[i] * Math.pow(xr, i));
    float tol = 1e-6f;
    if (Math.abs(resultado) <= tol)
      return true;
    return false;
  }
}
