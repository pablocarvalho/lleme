
public class Vetor {

  public static void main(String[] args) {
    float[] medidas = null;
    float[] histograma = null;
    float min = 0.5f;
    float max = 3.0f;
    int n = 5;

    histograma(medidas, min, max, n, histograma);

  }

  public static void histograma(float[] medidas, float min, float max, int n, float[] histograma) {
    float delta = (max - min) / n;
    int faixa = 0;

    for (int i = 0; i < histograma.length; i++)
      histograma[i] = 0;
    for (int i = 0; i < medidas.length; i++) {
      faixa = (int) ((medidas[i] - min) / delta);
      faixa = (faixa == n ? faixa - 1 : faixa);
      histograma[faixa]++;
    }
    for (int i = 0; i < histograma.length; i++)
      histograma[i] /= medidas.length * 100;
  }
}
