package exemplos.oo.histograma;

public class Histograma {

  private float min;
  private float max;
  private int n;
  private float[] freq;
  private int count;

  public Histograma(float min, float max, int n) {
    this.min = min;
    this.max = max;
    this.n = n;
    freq = new float[n];
  }

  public void countNumber(float numero) throws Exception {
    if (numero < min || numero > max)
      throw new Exception("Numero invalido");
    int pos = (int) ((numero - min) / ((max - min) / n));
    pos = pos == n ? n - 1 : pos;
    freq[pos]++;
    count++;
  }

  public void uncountNumber(float numero) throws Exception {
    if (numero < min || numero > max)
      throw new Exception("Numero invalido");
    int pos = (int) ((numero - min) / ((max - min) / n));
    pos = pos == n ? n - 1 : pos;
    freq[pos]--;
    count--;
  }

  public float[] getFreq() {
    float[] freqPercent = new float[n];
    for (int i = 0; i < freq.length; i++)
      freqPercent[i] = freq[i] / count;
    return freqPercent;
  }

  public float getFreq(int faixa) throws Exception {
    if (faixa < 0 || faixa >= n)
      throw new Exception("Faixa inexistente");
    return freq[faixa] / count;
  }

  public float getMin() {
    return min;
  }

  public float getmax() {
    return max;
  }

  public int getN() {
    return n;
  }

  public int getCount() {
    return count;
  }
}
