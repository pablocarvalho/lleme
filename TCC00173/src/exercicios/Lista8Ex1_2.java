package exercicios;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Lista8Ex1_2 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    int[][] tab = ler_tabela();
    System.out.println("Líder " + lider(tab));
  }

  public static int saldo(int time, int[][] tab) {
    return tab[time][4] - tab[time][5];
  }

  public static int lider(int[][] tab) {
    int melhor_pontuacao = -1, melhor_time = -1;
    for (int i = 0; i < tab.length; i++)
      if (tab[i][0] > melhor_pontuacao) {
        melhor_pontuacao = tab[i][0];
        melhor_time = i;
      } else if (tab[i][0] == melhor_pontuacao)
        if (tab[i][1] > tab[melhor_time][1])
          melhor_time = i;
        else if (tab[i][1] == tab[melhor_time][1])
          if (saldo(i, tab) > saldo(melhor_time, tab))
            melhor_time = i;
          else if (saldo(i, tab) == saldo(melhor_time, tab))
            melhor_time = i;

    return melhor_time;
  }

  public static int[][] ler_tabela() throws FileNotFoundException, IOException {
    FileInputStream input = new FileInputStream(".\\dat\\Tabela.txt");
    int[][] tab = new int[8][6];
    int i = 0;
    int j = 0;
    Scanner in = new Scanner(input);
    while (in.hasNext()) {
      tab[i][j++] = in.nextInt();
      tab[i][j++] = in.nextInt();
      tab[i][j++] = in.nextInt();
      tab[i][j++] = in.nextInt();
      tab[i][j++] = in.nextInt();
      tab[i][j] = in.nextInt();
      i++;
      j = 0;
    }

    input.close();
    return tab;
  }

  public static int ultimo(int[][] tab) {
    int pior_pontuacao = 100, pior_time = -1;
    for (int i = 0; i < tab.length; i++)
      if (tab[i][0] < pior_pontuacao) {
        pior_pontuacao = tab[i][0];
        pior_time = i;
      } else if (tab[i][0] == pior_pontuacao)
        if (tab[i][1] < tab[pior_time][1])
          pior_time = i;
        else if (tab[i][1] == tab[pior_time][1])
          if (saldo(i, tab) < saldo(pior_time, tab))
            pior_time = i;
          else if (saldo(i, tab) == saldo(pior_time, tab))
            pior_time = i;

    return pior_time;
  }

  public static int melhor_saldo(int[][] tab) {
    int saldo, melhor_saldo = - 1, melhor_time = -1;
    for (int i = 0; i < tab.length; i++) {
      saldo = tab[i][4] - tab[i][5];
      if (saldo > melhor_saldo) {
        melhor_saldo = saldo;
        melhor_time = i;
      }
    }
    return melhor_time;
  }
}
