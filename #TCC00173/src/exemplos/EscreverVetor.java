package exemplos;

public class EscreverVetor {

  public static void main(String[] args) {
    int vetor[] = {1, 2, 3, 4, 5};
    System.out.println(toString(vetor, 0));
  }

  public static String toString(int v[], int i) {
    if (i >= 0 && i < v.length)
      return " " + v[i] + toString(v, ++i);
    else
      return "";
  }
}
