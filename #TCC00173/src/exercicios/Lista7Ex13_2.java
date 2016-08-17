package exercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Lista7Ex13_2 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    InputStream input = new FileInputStream("");
    Scanner in = new Scanner(input);
    float[][] resultado = new float[10][3];
    float media = 0;
    int i = 0;


    while (in.hasNext()) {
      resultado[i][0] = in.nextInt();
      resultado[i][1] = (in.nextFloat() + in.nextFloat()) / 2;
      media += resultado[i][1];
      i++;
    }
    media = media / i;

    for (int j = 0; j < resultado.length; j++)
      if (resultado[j][1] < media)
        resultado[j][2] = -1;
      else if (resultado[j][1] == media)
        resultado[j][2] = 0;
      else
        resultado[j][2] = 1;

    for (float[] aluno : resultado)
      System.out.println(aluno[0] + "\t" + aluno[1] + "\t" + aluno[2]);

    input.close();

  }
}
