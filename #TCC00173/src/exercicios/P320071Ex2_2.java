package exercicios;

public class P320071Ex2_2 {

  public static void main(String[] args) {
    double v[] = {0.11, 0.2, 0.03, 0.56, 0.323, 0.345, 0.234, 0.56, 0.6546, 0.123, 0.123, 0.999};
    int histograma[] = new int[10];
    for (int i = 0; i < v.length; i++) {
      int var = faixa(v[i]);
      if (var != -1)
        histograma[var]++;

    }
    for (int i = 0; i < histograma.length; i++)
      System.out.println(histograma[i]);
  }

  public static int faixa(double n) {
    for (int i = 1; i <= 10; i++)
      if (n >= 0 && n < (i / 10.0))
        return --i;
    return -1;


  }
}
