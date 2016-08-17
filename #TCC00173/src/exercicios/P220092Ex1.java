package exercicios;

import java.util.Scanner;

public class P220092Ex1 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Digite a taxa de variação da perfuração: ");
    float taxa_perfuracao = in.nextFloat();
    System.out.println("Digite a taxa de variação do revestimento: ");
    float taxa_revestimento = in.nextFloat();
    System.out.println("valor básico da perfuração: ");
    float valor_basico_perfuracao = in.nextFloat();
    System.out.println("valor basico do revestimento: ");
    float valor_basico_revestimento = in.nextFloat();
    System.out.println("Quantidade de poços: ");
    int n = in.nextInt();
    float profundidade = 0, soma = 0, custototal = 0;
    for (int i = 0; i < n; i++) {
      do {
        System.out.println("Digite o valor da profundidade: ");
        profundidade = in.nextFloat();
      } while (profundidade <= 0);
      custototal = (calcula_custo_total(profundidade, valor_basico_perfuracao,
              valor_basico_revestimento, taxa_perfuracao, taxa_revestimento));
      soma += custototal;
      System.out.println("custo total: " + custototal);
    }
    System.out.println("média" + soma / n);

  }

  public static float calcula_custo_tarefa(float profundidade, float valor_basico, float tx) {
    float valor_final = 0;
    for (int i = 0; i < profundidade; i++)
      valor_final += (float) (valor_basico * Math.pow(1 + tx, i));

    return valor_final;

  }

  public static float calcula_custo_total(float profundidade, float valor_basico1, float valor_basico2, float taxa1, float taxa2) {
    float perfuracao = calcula_custo_tarefa(profundidade, valor_basico1, taxa1);
    float revestimento = calcula_custo_tarefa(profundidade, valor_basico2, taxa2);

    return perfuracao + revestimento;
  }
}
