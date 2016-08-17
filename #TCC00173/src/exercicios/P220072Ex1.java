package exercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class P220072Ex1 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    float dados[][] = new float[50][4];
    int n = lerArquivo("entrada.txt", dados);
    float lucro = 0;
    for (int i = 0; i < n; i++)
      lucro = lucro + dados[i][1] * (dados[i][3] - dados[i][2]);
    System.out.println(lucro);
    int produto = 453;
    System.out.println(lucroProduto(produto, dados, n));
  }

  public static float lucroProduto(int produto, float dados[][], int n) {
    for (int i = 0; i < n; i++)
      if (dados[i][0] == produto)
        return dados[i][1] * (dados[i][3] - dados[i][2]);
    return 0.0f;
  }

  public static int lerArquivo(String nomeArquivo, float dados[][]) throws FileNotFoundException, IOException {
    InputStream input = new FileInputStream("entrada.txt");
    Scanner in = new Scanner(input);
    int i = 0, j = 0;
    while (in.hasNext()) {
      for (j = 0; j < 4; j++)
        dados[i][j] = Float.parseFloat(in.next());
      i++;
    }
    input.close();
    return i;
  }
}
