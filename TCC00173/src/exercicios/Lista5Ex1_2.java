package exercicios;

public class Lista5Ex1_2 {

  public static void main(String[] args) {

    int x, produto = 1;
    for (x = 1; x < 16; x += 2)
      produto = produto * x;
    System.out.println(produto);
  }
}
