package exemplos;

public class PesquisaBinaria {

  public static void main(String[] args) {
    int[] v = {1, 4, 23, 27, 34, 56, 78, 100};
    System.out.println(procurar(v, 34));
  }

  public static int procurar(int[] v, int chave) {
    return procurar(v, chave, 0, v.length - 1);
  }

  public static int procurar(int[] v, int chave, int i, int j) {
    int q = (i + j) / 2;
    if (i == j && v[i] == chave)
      return i;
    else if (i == j)
      return -1;
    else if (chave <= v[q])
      return procurar(v, chave, i, q);
    else
      return procurar(v, chave, q + 1, j);
  }
}
