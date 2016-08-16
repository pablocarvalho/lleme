package provas.s20111;

public class P120111Ex4 {

  public static void main(String[] args) {
    float[] categorias = {2.3f, 3.5f, 4.7f};
    float[] numeros = {1.3f, 1.4f, 2.5f, 2.6f, 3.5f, 3.5f, 3.6f, 4.7f};
    float[] hist = histograma(numeros, categorias);
    for (int i = 0; i < hist.length; i++)
      System.out.println("categ " + i + " =" + hist[i]);

  }

  public static float[] histograma(float[] numeros, float[] categorias) {
    float hist[] = new float[categorias.length - 1];
    int categ, count = 0;
    for (int i = 0; i < numeros.length; i++) {
      categ = categoria(numeros[i], categorias);
      if (categ >= 0) {
        hist[categ]++;
        count++;
      }
    }
    if (count > 0)
      for (int i = 0; i < hist.length; i++)
        hist[i] /= count;
    return hist;
  }

  public static int categoria(float numero, float[] categs) {
    int categ = -1;
    if (numero >= categs[0] && numero <= categs[categs.length - 1]) {
      if (numero == categs[categs.length - 1])
        return categs.length - 2;
      for (categ = 0; categ < categs.length - 2; categ++)
        if (numero >= categs[categ] && numero < categs[categ + 1])
          return categ;
    }
    return categ;
  }
}
