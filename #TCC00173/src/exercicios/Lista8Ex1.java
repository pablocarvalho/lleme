package exercicios;

public class Lista8Ex1 {

  public static void main(String[] args) {
    int[][] tabela = {{9, 3, 0, 2, 10, 5}, {7, 2, 1, 1, 9, 5}, {8, 2, 2, 1, 5, 1},
      {9, 2, 3, 0, 10, 4}, {7, 2, 1, 2, 9, 6}, {7, 2, 1, 2, 3, 1}, {9, 3, 0, 2, 8, 2},
      {6, 2, 0, 3, 7, 9}};
    System.out.println(melhorSaldo(tabela));
    System.out.println(lider(tabela));
  }

  public static int melhorSaldo(int tab[][]) {
    int timeMaiorSaldo = 0;
    for (int i = 1; i < tab.length; i++)
      if ((tab[i][4] - tab[i][5]) > (tab[timeMaiorSaldo][4] - tab[timeMaiorSaldo][5]))
        timeMaiorSaldo = i;
    return timeMaiorSaldo;
  }

  public static int lider(int tab[][]) {
    int timeLider = 0;
    for (int i = 1; i < tab.length; i++)
      if (tab[i][0] > tab[timeLider][0])
        timeLider = i;
      else if (tab[i][0] == tab[timeLider][0])
        if (tab[i][1] > tab[timeLider][1])
          timeLider = i;
        else if (tab[i][1] == tab[timeLider][1])
          if (tab[i][4] - tab[i][5] > tab[timeLider][4] - tab[timeLider][5])
            timeLider = i;
    return timeLider;
  }
}
