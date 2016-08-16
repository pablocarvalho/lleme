package provas.s20112;

public class P220112Ex1 {

  public static void main(String[] args) {
    float[] numeros = {2.3f, 2.4f, 3.5f, 8.4f, 8.6f, 7.2f, 8.1f, 9.5f,
      10f, 7f, 8f};
    int faixas = 3;
    float[] histograma = histograma(numeros, faixas);
    for (int i = 0; i < histograma.length; i++)
      System.out.println(">= " + (i * 10f / faixas) + ": " + histograma[i] * 100f);

  }

  public static float[] histograma(float[] numeros, int faixas) {
    float[] histograma = new float[faixas];
    float delta = 10f / faixas;
    int faixa;
    for (int i = 0; i < numeros.length; i++) {
      faixa = (int) (numeros[i] / delta);
      if (faixa == faixas)
        faixa--;
      for (int j = faixa; j >= 0; j--)
        histograma[j]++;
    }
    for (int i = 0; i < faixas; i++)
      histograma[i] /= numeros.length;
    return histograma;
  }
}
