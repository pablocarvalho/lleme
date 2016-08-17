package exemplos;

public class Lista9Ex6 {

  public static void main(String[] args) {
    int[] v = {1, -10, 2, 5, -15};
    System.out.println(somaPositivos(v, 0));

  }

  public static int somaPositivos(int[] v, int pos) {
    if (pos == v.length - 1)
      if (v[pos] > 0)
        return v[pos];
      else
        return 0;
    if (v[pos] > 0)
      return v[pos] + somaPositivos(v, pos + 1);
    else
      return somaPositivos(v, pos + 1);
  }
}
