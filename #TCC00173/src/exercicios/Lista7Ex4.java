package exercicios;

public class Lista7Ex4 {

  public static void main(String[] args) {
    int[] vet = {2, 3, 7, 12, 2};
    int[] vet2 = somatorios(vet);
    for (int elm : vet2)
      System.out.println(elm);

    int[][] mat = null;
    for (int[] linha : mat) {
      for (int elm : linha)
        System.out.println(elm + "\t");
      System.out.println("");
    }

  }

  public static int[] somatorios(int[] v) {
    int[] w = new int[v.length];
    w[0] = v[0];
    for (int i = 1; i < v.length; i++)
      //if (i > 0 && i < v.length)
      w[i] = v[i] + w[i - 1];
    return w;
  }
}
