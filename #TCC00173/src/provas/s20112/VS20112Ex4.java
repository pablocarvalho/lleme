package provas.s20112;

public class VS20112Ex4 {

  public static void main(String[] args) {
    int[] cores = {1, 2, 3, 3, 3, 0, 1, 1};
    float[] histograma = histograma(cores);
    for (int i = 0; i < histograma.length; i++)
      System.out.println(i + ":" + histograma[i]);
  }

  public static float[] histograma(int[] cores) {
    float[] histograma = new float[4];
    for (int i = 0; i < cores.length; i++)
      histograma[cores[i]]++;
    for (int i = 0; i < histograma.length; i++)
      histograma[i] /= cores.length;
    return histograma;
  }
}
