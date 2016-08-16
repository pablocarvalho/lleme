package exercicios;

public class P120111Ex4 {

  public static void main(String[] args) {
    float[] numeros = {2.3f, 3.4f, 4.7f, 5.8f};
    float[] categs = {2, 3, 5};
    float[] histograma = histograma(numeros, categs);
    for (int i = 0; i < histograma.length; i++)
      System.out.println(histograma[i]);
  }

  public static int categoria(float numero, float[] vet) {
    if (numero == vet[vet.length - 1])
      return vet.length - 1;
    for (int i = 0; i < vet.length - 1; i++)
      if (numero >= vet[i] && numero < vet[i + 1])
        return i;
    return -1;
  }

  public static float[] histograma(float[] numeros, float[] categs) {
    int categoria = 0;
    int contador = 0;
    float[] hist = new float[categs.length - 1];
    for (int i = 0; i < numeros.length; i++) {
      categoria = categoria(numeros[i], categs);
      if (categoria >= 0) {
        hist[categoria]++;
        contador++;
      }
    }
    for (int j = 0; j < hist.length; j++)
      hist[j] /= contador;
    return hist;
  }
}