package provas.s20102;

public class P120102Ex3 {

  public static void main(String[] args) {
    System.out.println(somaDivisiveis(10, 21));
  }

  public static int somaDivisiveis(int n1, int n2) {
    int soma = 0;
    for (int i = n1; i <= n2; i++)
      if ((i % 5) == 0 || (i % 7) == 0)
        soma = soma + i;
    return soma;
  }
}
