package exemplos;

public class Lista9Ex5 {

  public static void main(String[] args) {
    int[] v = {10, 2, 40, 2, 9};
    System.out.println(maior(v, 0));
  }

  public static int maior(int[] v, int pos) {
    if (pos == v.length - 1)
      return v[pos];
    int max = maior(v, pos + 1);
    if (v[pos] > max)
      return v[pos];
    else
      return max;


  }
}
