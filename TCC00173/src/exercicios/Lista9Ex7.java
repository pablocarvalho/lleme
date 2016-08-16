package exercicios;

public class Lista9Ex7 {

  public static void main(String[] args) {
    int numero = 2306718;
    System.out.println(somaDigitos(numero));
    System.out.println(2 + 3 + 0 + 6 + 7 + 1 + 8);
  }

  public static int somaDigitos(int numero) {
    if (numero < 10)
      return numero;
    else
      return (numero % 10) + somaDigitos(numero / 10);
  }
}
