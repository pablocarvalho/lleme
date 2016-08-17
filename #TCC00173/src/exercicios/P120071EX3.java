package exercicios;

import java.io.*;
import java.util.Scanner;

public class P120071EX3 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    OutputStream output = new FileOutputStream("./dat/notas.txt", true);
    OutputStreamWriter writer = new OutputStreamWriter(output);
    BufferedWriter bw = new BufferedWriter(writer);

    InputStream input = new FileInputStream("alunos.txt");
    Scanner in = new Scanner(input);

    float p1 = 0, p2 = 0, p3 = 0, media = 0;
    int contador = 0;
    while (in.hasNext()) {
      contador++;
      p1 = in.nextFloat();
      p2 = in.nextFloat();
      if ((p1 + p2) < 10 || p1 < 3 || p2 < 3) {
        p3 = in.nextFloat();
        media = (maiorNota(p1, p2) + p3) / 2;
        if (media >= 5)
          bw.write("aluno " + contador + " Aprovado\n");
        else
          bw.write("aluno " + contador + " Reprovado\n");
      } else
        bw.write("aluno " + contador + " Aprovado\n");
    }
    bw.close();
    input.close();
  }

  public static float maiorNota(float a, float b) {
    if (a > b)
      return a;
    return b;
  }
}
