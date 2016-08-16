package exercicios;

public class P320071Ex2 {

  public static void main(String[] args) {
    float dados[] = {0.11f, 0.2f, 0.03f, 0.56f, 0.323f, 0.345f, 0.234f, 0.56f, 0.6546f, 0.123f, 0.123f, 0.999f};
    float histograma[] = new float[10];
    histograma(dados, histograma);
    escreve(histograma);
  }

  public static void escreve(float[] v) {
    for (int i = 0; i < v.length; i++)
      System.out.print(v[i] + " ");
  }

  public static void histograma(float v[], float h[]) {
    for (int i = 0; i < v.length; i++)
      h[(int) (v[i] * 10)]++;
    for (int i = 0; i < h.length; i++)
      h[i] = (h[i] / v.length) * 100;
  }
}
