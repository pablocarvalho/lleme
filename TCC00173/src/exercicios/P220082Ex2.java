/*
 * Uma pesquisa eleitoral para eleicoes municipais possui margem de erro de
 * 3 pontos percentuais (para cima ou para baixo). Escreva um programa que le do
 * teclado o numero de candidatos e o percentual de votos esperado para cada
 * candidato e gera como saida para cada candidato tres numeros por linha:
 * percentual esperado, percentual minimo e percentual maximo. Os percentuais
 * (esperado, minimo e maximo) devem ser valores reais entre 0 e 100 e a soma
 * dos percentuais esperados nao pode exceder 100. Se uma dessas condicoes de
 * erro ocorrer, o programa deve fechar o arquivo, imprimir uma mensagem de
 * erro na tela e terminar sua execucao. Como exemplo, suponha a seguinte
 * entrada:
 *
 * Entre com o numero de candidatos:
 * Entre com o percentual esperado para o candidato 1: 20
 * Entre com o percentual esperado para o candidato 2: 12.4
 * Entre com o percentual esperado para o candidato 3: 2
 * Entre com o percentual esperado para o candidato 4: 5.6
 */
package exercicios;

import java.util.Scanner;

public class P220082Ex2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Numero de candidatos:");
    int numero_candidatos = in.nextInt();
    float percentual;
    float soma = 0;

    for (int i = 0; i < numero_candidatos; i++) {
      System.out.println("Percentual:");
      percentual = in.nextFloat();
      if (percentual > 100 || percentual < 0) {
        System.out.println("Error");
        i = i - 1;
      } else if ((soma + percentual) <= 100) {
        soma = percentual + soma;
        System.out.println("Candidato " + (i + 1) + " = " + percentual + " " + (percentual - 3) + " " + (percentual + 3));
      } else {
        System.out.println("Error");
        i = i - 1;
      }

    }
  }
}
