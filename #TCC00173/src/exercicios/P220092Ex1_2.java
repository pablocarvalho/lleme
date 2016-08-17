package exercicios;

import java.util.Scanner;

public class P220092Ex1_2 {

  public static void main(String[] args) {
    float custoPoco1 = recebeCalculaValor();
    float custoPoco2 = recebeCalculaValor();
    float custoPoco3 = recebeCalculaValor();
    System.out.println(
            "O custo médio é:" + (custoPoco1 + custoPoco2 + custoPoco3) / 3);


  }

  public static float recebeCalculaValor() {
    Scanner in = new Scanner(System.in);
    System.out.println("Insira a profundidade:");
    float prof = in.nextFloat();
    System.out.println("Insira o custo inicial de perfuração");
    float custoInicialPf = in.nextFloat();
    System.out.println("Insira o custo inicial de revestimento");
    float custoInicialRes = in.nextFloat();
    System.out.println("Insira a taxa de acréscimo de perfuração");
    float taxaPerfuracao = in.nextFloat();
    System.out.println("Insira a taxa de acréscimo de revestimento");
    float taxaRevestimento = in.nextFloat();
    float custoPerfuracao = calculaValor(prof, custoInicialPf,
            taxaPerfuracao);
    float custoRevestimento = calculaValor(prof, custoInicialRes,
            taxaRevestimento);
    return custoPerfuracao + custoRevestimento;

  }

  public static float calculaValor(float prof, float valorBasico, float tx) {
    return (float) (valorBasico * (Math.pow(tx, Math.ceil(prof)) - 1) / (tx - 1));

  }
}
