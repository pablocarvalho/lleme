package exercicios;

public class Lista5Ex5 {

  public static void main(String[] args) {
    int x = 4;
    int n = -3;
    double acumulador_produto = 1.0;

    for (; n < 0; n++)
      acumulador_produto *= (1.0 / x);
    System.out.println(acumulador_produto);
  }
}
