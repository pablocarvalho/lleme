package exercicios;

public class Lista5Ex1_v2 {

  public static void main(String[] args) {
    int inicio;
    int fim;

    int produto = 1;

    inicio = 1;
    do {
      produto *= inicio;
      inicio += 2;
    } while (inicio <= 15);

    System.out.println(produto);


  }
}
