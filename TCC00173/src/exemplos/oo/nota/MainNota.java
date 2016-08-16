package exemplos.oo.nota;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MainNota {

  public static void main(String[] args) throws FileNotFoundException, IOException {

    InputStream input = new FileInputStream("notas.txt");
    Scanner in = new Scanner(input);
    Nota[] notasTrabalho = new Nota[3];
    int i = 0;
    while (in.hasNext())
      notasTrabalho[i++] = new Nota(in.nextInt(), in.nextFloat());
    input.close();

    input = new FileInputStream("notasP3.txt");
    in = new Scanner(input);
    Nota[] notasP3 = new Nota[3];
    i = 0;
    while (in.hasNext()) {
      notasP3[i] = new Nota();
      notasP3[i].matricula = in.nextInt();
      notasP3[i].nota = in.nextFloat();
      i++;
    }
    input.close();

    int pos;
    for (i = 0; i < notasP3.length; i++) {
      pos = busca(notasP3[i].matricula, notasTrabalho);
      if (pos >= 0)
        System.out.println(0.7f * notasP3[i].nota + 0.3f * notasTrabalho[pos].nota);
    }
  }

  public static int busca(int matricula, Nota[] notas) {
    for (int i = 0; i < notas.length; i++)
      if (notas[i].matricula == matricula)
        return i;
    return -1;
  }
}
