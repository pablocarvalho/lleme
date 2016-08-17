package exemplos;

import java.util.Scanner;

public class Variancia {

  public static void main(String[] args) {
    float[] notas = new float[50];
    float soma = 0, media, var, numero;
    int qtd = 0;
    Scanner in = new Scanner(System.in);

    numero = in.nextFloat();
    while (numero >= 0 && qtd < 50) {
      notas[qtd] = numero;
      soma += notas[qtd];
      qtd++;
      numero = in.nextFloat();
    }
    media = soma / qtd;

    var = 0;
    for (int i = 0; i < qtd; i++)
      var += ((float) Math.pow(notas[i] - media, 2));
    var = var / qtd;

    in.close();

  }
}
