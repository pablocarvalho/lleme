package exercicios;

public class P320071Ex2_3 {

  public static void main(String[] args) {
    float v[] = {0.11f, 0.2f, 0.03f, 0.56f, 0.323f, 0.345f, 0.234f, 0.56f,
      0.6546f, 0.123f, 0.123f, 0.999f, 1f};
    int numFaixas = 10;
    float min = 0.0f;
    float max = 1.0f;
    imprimeVetor(histograma(v, numFaixas, min, max));
    teste();
  }

  public static void teste() {
  }

  public static float[] histograma(float v[], int numFaixas, float min,
          float max) {
    float delta = Math.abs(max - min) / numFaixas;
    float h[] = new float[numFaixas];
    int faixa;
    int qtd = 0;
    for (int i = 0; i < v.length; i++)
      if (v[i] >= min && v[i] <= max) {
        faixa = (int) (Math.abs(v[i] - min) / delta);
        faixa = faixa >= h.length ? h.length - 1 : faixa;
        h[faixa]++;
        qtd++;
      }
    for (int g = 0; g < h.length; g++)
      h[g] /= qtd;

    return h;
  }

  public static void imprimeVetor(float h[]) {
    for (int i = 0; i < h.length; i++)
      System.out.println(h[i]);
  }
}
