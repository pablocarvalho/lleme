package exemplos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class HistogramaComGrafico {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    InputStream input = new FileInputStream(".\\dat\\NotasT.txt");
    Scanner in = new Scanner(input);

    float nota;
    int faixas = 3;
    int vet[] = new int[faixas];
    int totalnotas = 0;
    float inferior = 5;
    float superior = 8;
    float delta = (superior - inferior) / faixas;
    int pos;

    while (in.hasNext()) {
      nota = in.nextFloat();
      if (nota >= inferior && nota <= superior) {
        pos = (int) ((nota - inferior) / delta);
        totalnotas++;
        if (pos == faixas)
          vet[faixas - 1]++;
        else
          vet[pos]++;
      }
    }
    input.close();

    //for (int i = 0; i < vet.length; i++)
    //    System.out.println(i + "\t" + vet[i] / totalnotas * 100);
    for (int linha = 0; linha < 10; linha++) {
      for (int coluna = 0; coluna < faixas; coluna++)
        if (linha < (10 - (int) ((float) vet[coluna] / totalnotas * 10)))
          System.out.print(" \t");
        else
          System.out.print("X\t");
      System.out.println("");
    }
  }
}
