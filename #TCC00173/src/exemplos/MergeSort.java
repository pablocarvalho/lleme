package exemplos;

public class MergeSort {

  public static void main(String[] args) {
    int[] v = {100, 1, 3, 99, 4, 7, 18, 23, 2, 5, 4, 7, 19, 67, 6};
    mergeSort(v, 0, v.length - 1);
    System.out.println(EscreverVetor.toString(v, 0));
  }

  public static void mergeSort(int[] v, int p, int r) {
    int q;
    if (p < r) {
      q = (p + r) / 2;
      mergeSort(v, p, q);
      mergeSort(v, q + 1, r);
      merge(v, p, q, r);
    }
  }

  public static void merge(int[] v, int p, int q, int r) {
    int[] vaux = new int[r - p + 1];
    int i = p;
    int j;
    for (j = 0; j < vaux.length; j++)
      vaux[j] = v[i++];
    i = 0;
    j = q - p + 1;
    for (int k = p; k <= r; k++)
      if (i > (q - p) || (j <= (r - p) && vaux[j] < vaux[i]))
        v[k] = vaux[j++];
      else
        v[k] = vaux[i++];
  }
}
