package exercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Lista7Ex13 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    int n = 50, qtdAlunos = 0;
    float mediaTurma = 0.0f;
    int[] m = new int[n];
    float p1[] = new float[n], p2[] = new float[n], media[] = new float[n];
    qtdAlunos = lerArquivo("entrada.txt", m, p1, p2, media);
    mediaTurma = media(qtdAlunos, media);
    for (int i = 0; i < qtdAlunos; i++)
      if (media[i] < mediaTurma)
        System.out.println(m[i] + " " + "abaixo");
      else if (media[i] == mediaTurma)
        System.out.println(m[i] + " " + "na media");
      else
        System.out.println(m[i] + " " + "acima");
    System.out.println(situacao(98868, qtdAlunos, m, p1, p2, media, mediaTurma));
  }

  public static String situacao(int matricula, int qtdAlunos, int matriculas[], float[] p1, float[] p2, float[] media, float medioaTurma) {
    String mensagem = null;
    String situacao;
    for (int i = 0; i < qtdAlunos; i++)
      if (matriculas[i] == matricula) {
        if (media[i] < medioaTurma)
          situacao = "abaixo";
        else if (media[i] == medioaTurma)
          situacao = "na media";
        else
          situacao = "acioma";
        mensagem = "Aluno " + matricula + " p1= " + p1[i] + " p2= " + p2[i] + " situacao= " + situacao;
      }
    if (mensagem == null)
      return "aluno não existe";
    return mensagem;
  }

  public static float media(int qtdAlunos, float[] media) {
    float mediaTurma = 0.0f;


    for (int i = 0; i
            < qtdAlunos; i++)
      mediaTurma = mediaTurma + media[i];
    return mediaTurma / qtdAlunos;


  }

  public static int lerArquivo(String arquivo, int[] matriculas, float[] p1, float[] p2, float media[]) throws FileNotFoundException, IOException {
    InputStream input;
    input = new FileInputStream(arquivo);
    Scanner in = new Scanner(input);


    int alunos = 0;


    while (in.hasNext()) {
      matriculas[alunos] = in.nextInt();
      p1[alunos] = in.nextFloat();
      p2[alunos] = in.nextFloat();
      media[alunos] = (p1[alunos] + p2[alunos]) / 2;
      alunos++;

    }


    input.close();


    return alunos;

  }
}
