package exemplos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MegaSena {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    InputStream input = new FileInputStream("entrada.txt");
    Scanner in = new Scanner(input);
    int n;
    int contador[] = new int[60];
    while (in.hasNext()) {
      n = in.nextInt();
      contador[n - 1]++;
    }
    mostraVetor(contador);
    input.close();
  }

  public static void mostraVetor(int v[]) {
    for (int i = 0; i < v.length; i++)
      System.out.println((i + 1) + "-" + v[i]);
  }
}
