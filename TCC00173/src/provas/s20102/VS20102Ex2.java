package provas.s20102;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class VS20102Ex2 {

  public static void main(String[] args) throws FileNotFoundException {
    InputStream input = new FileInputStream("estagiarios.txt");
    Scanner in = new Scanner(input);
    int cargasHorarias[][] = new int[4][2];
    int i = 0;
    while (in.hasNext()) {
      cargasHorarias[i][0] = in.nextInt();
      cargasHorarias[i][1] = in.nextInt();
      i++;
    }
    in.close();

    input = new FileInputStream("ponto.txt");
    in = new Scanner(input);
    int cargaHoraria, ferias, ponto[] = new int[7];
    while (in.hasNext()) {
      ponto[0] = in.nextInt();
      ponto[1] = in.nextInt();
      ponto[2] = in.nextInt();
      ponto[3] = in.nextInt();
      ponto[4] = in.nextInt();
      ponto[5] = in.nextInt();
      ponto[6] = in.nextInt();
      cargaHoraria = buscaCargaHoraria(ponto[0], cargasHorarias);
      ferias = calcFerias(cargaHoraria, ponto);
      System.out.println("matricula " + ponto[0] + " " + ferias
              + " dias de ferias");
    }
    in.close();
  }

  public static int buscaCargaHoraria(int matricula, int[][] cargasHorarias) {
    for (int i = 0; i < cargasHorarias.length; i++)
      if (cargasHorarias[i][0] == matricula)
        return cargasHorarias[i][1];
    return 0;
  }

  public static int calcFerias(int cargaHoraria, int[] ponto) {
    boolean caso1 = true;
    float somaHoras = 0;
    int dias = 0;
    for (int i = 1; i < ponto.length; i++) {
      if (ponto[i] < cargaHoraria)
        caso1 = false;
      else
        dias++;
      somaHoras += ponto[i];
    }
    if (caso1)
      dias = 15;
    else if (somaHoras >= cargaHoraria * (ponto.length - 1))
      dias = 10;
    return dias;
  }
}
