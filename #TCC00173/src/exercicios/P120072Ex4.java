/*
 * Escreva uma func~ao para calcular a soma dos numeros pares inteiros que
 * existem entre n1 e n2, incluindo ambos se for o caso. A func~ao deve receber
 * como par^ametrosos dois numeros e ter como retorno o valor da soma calculado,
 * seguindo o cabecalho abaixo:
 *
 * public static int somaPares (int n1,int n2)
 */
package exercicios;

public class P120072Ex4 {

  public static void main(String[] args) {
    int n1 = 1, n2 = 11;
    System.out.println(somaPares(n1, n2));
  }

  public static int somaPares(int n1, int n2) {
    int soma = 0;
    for (int i = n1; i <= n2; i++)
      if (i % 2 == 0)
        soma = soma + i;
    return soma;
  }
}
