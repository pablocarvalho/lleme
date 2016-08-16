package exercicios;

public class Lista9Ex5_3 {

  public static void main(String[] args) {

    float[] numeros = {230, 1, 5, 10, 100, 6};
    System.out.println(maximo(numeros, 0));

  }

  public static float maximo(float[] numeros, int n) {
    if (numeros.length == 1 || n == numeros.length - 1)
      return numeros[n];
    else {
      float max = maximo(numeros, n + 1);
      if (numeros[n] > max)
        return numeros[n];
      else
        return max;
    }
  }
}
