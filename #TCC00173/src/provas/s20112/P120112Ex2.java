package provas.s20112;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P120112Ex2 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    InputStream input = new FileInputStream(".\\dat\\notas.txt");
    Scanner in = new Scanner(input);

    OutputStream output = new FileOutputStream(".\\dat\\saida.txt", false);
    OutputStreamWriter writer = new OutputStreamWriter(output);
    BufferedWriter bw = new BufferedWriter(writer);

    int qtdMaxAlunos = 50, qtdAlunos = 0;
    float media = 0;
    int[] matriculas = new int[qtdMaxAlunos];
    float[] notas = new float[qtdMaxAlunos];

    while (in.hasNext() && qtdAlunos < qtdMaxAlunos) {
      matriculas[qtdAlunos] = in.nextInt();
      notas[qtdAlunos] = in.nextFloat();
      media += notas[qtdAlunos];
      qtdAlunos++;
    }
    media /= qtdAlunos;

    for (int i = 0; i < notas.length; i++)
      if (notas[i] < media && matriculas[i] != 0)
        bw.write("" + matriculas[i] + "\t" + notas[i] + "\n");


    bw.close();
    input.close();
  }
}
