package exemplos;

public class IdentificaPadrao {

  public static void main(String[] args) throws Exception {
    int[][] p = {{4, 5, 5, 6}, {2, 2, 2, 1}, {7, 2, 1, 2}};
    int[][] l = {{2, 2}, {2, 1}};
    System.out.println(identificaPadrao(p, l));
  }

  public static boolean identificaPadrao(int[][] a, int[][] padrao) throws Exception {
    if (a.length < padrao.length || a[0].length < padrao[0].length)
      throw new Exception();
    for (int i = 0; i <= a.length - padrao.length; i++)
      for (int j = 0; j <= a[0].length - padrao[0].length; j++)
        if (existe(padrao, a, i, j))
          return true;
    return false;
  }

  private static boolean existe(int[][] padrao, int[][] a, int i, int j) {
    for (int k = 0; k < padrao.length; k++)
      for (int l = 0; l < padrao[0].length; l++)
        if (padrao[k][l] != a[k + i][l + j])
          return false;
    return true;
  }
}
