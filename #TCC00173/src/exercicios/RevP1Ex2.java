/*
 * Considere uma disciplina que adota o seguinte criterio de aprovacao: os
 * alunos fazem duas provas (P1 e P2) iniciais; se a media nessas duas provas
 * for maior ou igual a 5.0, e se nenhuma das duas notas for inferior a 3.0, o
 * aluno passa direto. Caso contrario, o aluno faz uma terceira prova (P3) e a
 * media e calculada considerando-se essa terceira nota e a maior das notas
 * entre P1 e P2. Neste caso, o aluno e aprovado se a media final for maior ou
 * igual a 5.0.
 *
 * Escreva um programa completo que leia inicialmente as duas notas de um aluno,
 * fornecidas pelo usuario via teclado. Se as notas n~ao forem suciente para o
 * aluno passar direto, o programa deve capturar a nota da terceira prova,
 * tambem fornecida via o teclado.
 *
 * Como saida, o programa deve imprimir a media final do aluno, seguida da
 * mensagem Aprovado ou Reprovado, conforme o criterio descrito acima.
 */
package exercicios;

public class RevP1Ex2 {

  public static void main(String[] args) {
    int n = 5;
    System.out.println(hn(n));
  }

  public static float hn(int n) {
    float soma = 0;
    int i = 1;
    for (i = 1; i <= n; i++)
      soma = soma + (1.0f / i);
    return soma;
  }
}
