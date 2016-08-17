package exemplos;

import java.io.*;
import java.util.Scanner;

public class Sorteio {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    String[] alunos = leAlunos();
    int[] sorteados = leSorteios();

    OutputStream output = new FileOutputStream(".\\dat\\sorteados.txt", true);
    OutputStreamWriter writer = new OutputStreamWriter(output);
    BufferedWriter bw = new BufferedWriter(writer);
    int sorteio;
    do
      sorteio = sorteio();
    while (foiSorteado(sorteio, sorteados));
    bw.write("" + sorteio + "\n");
    System.out.println(alunos[sorteio]);

    bw.close();

  }

  public static int sorteio() {
    int numero = (int) (Math.random() * 29);
    return numero;
  }

  public static boolean foiSorteado(int n, int[] sorteados) {
    for (int i = 0; i < sorteados.length; i++)
      if (sorteados[i] == n)
        return true;
    return false;
  }

  public static String[] leAlunos() throws FileNotFoundException {
    InputStream input = new FileInputStream(".\\dat\\alunos.txt");
    Scanner in = new Scanner(input);
    String[] alunos = new String[37];
    int i = 0;
    while (in.hasNext()) {
      alunos[i] = in.nextLine();
      i++;
    }
    in.close();
    return alunos;
  }

  public static int[] leSorteios() throws FileNotFoundException {
    InputStream input = new FileInputStream(".\\dat\\sorteados.txt");
    Scanner in = new Scanner(input);
    int[] sorteados = new int[100];
    int i = 0;
    while (in.hasNext()) {
      sorteados[i] = in.nextInt();
      i++;
    }
    in.close();
    return sorteados;
  }
}
