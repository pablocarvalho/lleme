package exercicios;

import java.util.Scanner;

public class Lista7Ex13_v2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int alunos = 50;
    int[] matriculas = new int[alunos];
    float[] n1 = new float[alunos];
    float[] n2 = new float[alunos];
    float[] medias = new float[alunos];

    int matricula = -1;
    float p1 = 0, p2 = 0, media = 0, mediaTurma = 0;
    int i = 0;

    do {
      System.out.println("Entre com a matricula");
      matricula = in.nextInt();
      if (matricula != 0) {
        p1 = in.nextInt();
        p2 = in.nextInt();
        media = (p1 + p2) / 2;

        matriculas[i] = matricula;
        n1[i] = p1;
        n2[i] = p2;
        medias[i] = media;
        mediaTurma += media;
        i++;
      }
    } while (i < 50 && matricula != 0);

    if (i != 0)
      mediaTurma /= i;

    i = 0;
    while (matriculas[i] != 0) {
      String situacao = medias[i] >= mediaTurma ? "acima" : "abaixo";
      System.out.println(matriculas[i] + ", " + medias[i] + ", " + situacao);
      i++;
    }

  }
}
