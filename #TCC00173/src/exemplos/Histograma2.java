package exemplos;

public class Histograma2 {

  public static void main(String[] args) {
    float[] data = {9.5f, 7.8f, 6.6f, 9.5f, 7.3f, 8.4f};
    float[] hist = histograma(data, 0, 10, 10);
    int faixa = 0;
    for (float valor : hist)
      System.out.println("faixa " + (faixa++) + " = " + valor);
  }

  public static float[] histograma(float[] data, float min, float max, int qtdFaixas) {
    float[] hist = new float[qtdFaixas];
    float h = (max - min) / qtdFaixas;
    float qtdTotal = 0;
    int pos;
    for (int i = 0; i < data.length; i++)
      if (data[i] >= min && data[i] < max) {
        pos = (int) ((data[i] - min) / h);
        if (pos == qtdFaixas)
          pos--;
        hist[pos]++;
        qtdTotal++;
      }
    for (int i = 0; i < data.length; i++)
      hist[i] = hist[i] / qtdTotal;

    return hist;
  }
}
