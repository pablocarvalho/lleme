package exercicios;

public class Lista9Ex1_2 {

  public static void main(String[] args) {
  }

  public static float somaN(float[] numeros, int pos) {
    if (numeros.length == pos)
      return 0;
    else
      return numeros[0] + somaN(numeros, pos + 1);
  }

  public static float produtoN(float[] numeros, int pos) {
    if (numeros.length == pos)
      return 1;
    else
      return numeros[0] * produtoN(numeros, pos + 1);
  }
}
