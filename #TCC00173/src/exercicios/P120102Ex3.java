package exercicios;

public class P120102Ex3 {

  public static void main(String[] args) {
    System.out.println(somaDivisiveis(10, 21));

  }

  public static int somaDivisiveis(int n1, int n2) {
    int soma = 0;
    for (; n1 <= n2; n1++)
      if (n1 % 5 == 0 || n1 % 7 == 0)
        soma += n1;
    return soma;
  }
}
