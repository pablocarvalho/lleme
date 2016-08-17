package exemplos;

public class Hist {

  public static void main(String[] args) {
    float dados[] = {23.4f, 56.8f, 10.3f};
    float max = 100.0f, min = 0.0f;
    int faixas = 4, faixa, cont = 0;
    float hist[] = new float[faixas];

    for (int i = 0; i < dados.length; i++)
      if (teste(max, min, dados[i])) {
        cont++;
        faixa = faixa(dados[i], max, min, faixas);
        hist[faixa]++;
      }


  }

  public static int faixa(float n, float max, float min, int faixas) {
    float h = (max - min) / faixas;
    int i = (int) ((n - min) / h);
    return i;
  }

  public static boolean teste(float max, float min, float n) {
    return ((n >= min) && (n <= max));
  }
}
