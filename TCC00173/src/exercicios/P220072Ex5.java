package exercicios;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class P220072Ex5 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    float dados[][] = {{2.0f, 4.5f, 6.7f}, {-3.6f, 8.9f, 7.8f}};
    System.out.println(isMatrizPositiva(dados));
    salva(dados);
  }

  public static boolean isMatrizPositiva(float matriz[][]) {
    int qtdLinhas = matriz.length;
    int qtdColunas = matriz[0].length;

    for (int i = 0; i < qtdLinhas; i++)
      for (int j = 0; j < qtdColunas; j++)
        if (matriz[i][j] < 0)
          return false;

    return true;
  }

  public static void salva(float[][] matriz) throws FileNotFoundException, IOException {
    OutputStream output = new FileOutputStream("saida.txt", false);
    OutputStreamWriter writer = new OutputStreamWriter(output);
    BufferedWriter bw = new BufferedWriter(writer);

    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[0].length; j++)
        bw.write("" + matriz[i][j] + " ");
      bw.write("\n");
    }

    bw.close();
  }
}
