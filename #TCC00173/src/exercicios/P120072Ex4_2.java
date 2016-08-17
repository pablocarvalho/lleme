package exercicios;

public class P120072Ex4_2 {

  public static void main(String[] args) {
    System.out.println(somaPar(3, 10));
  }

  public static int somaPar(int n1, int n2) {
    int soma = 0;
    if (n1 % 2 != 0)
      n1++;
    for (; n1 <= n2; n1 += 2)
      soma += n1;

    return soma;
  }
}
