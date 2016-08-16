package provas.s20112;

public class P120112Ex3 {

  public static void main(String[] args) {

    int[][] matriz = {{1, 2, 4, 5, 1},
      {8, 1, 1, 2, 1},
      {2, 1, 3, 5, 1},
      {3, 1, 1, 1, 1},
      {5, 1, 4, 5, 1}};
    int[][] padrao = {{3, 5, 1},
      {1, 1, 1},
      {4, 5, 1}};

    System.out.println(verificaPadrao(matriz, padrao));

  }

  public static boolean verificaPadrao(int[][] matriz, int[][] padrao) {
    int fimLinha = matriz.length - padrao.length + 1;
    int fimColuna = matriz[0].length - padrao[0].length + 1;
    boolean encontrou = false;

    for (int i = 0; i < fimLinha && encontrou == false; i++)
      for (int j = 0; j < fimColuna && encontrou == false; j++) {
        encontrou = true;
        for (int k = i; k < i + padrao.length && encontrou; k++)
          for (int l = j; l < j + padrao[0].length && encontrou; l++)
            if (matriz[k][l] != padrao[k - i][l - j])
              encontrou = false;
      }
    return encontrou;
  }
}
