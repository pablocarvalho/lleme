package exercicios;

public class P220102Ex2 {

  private static int qtd = 0;

  public static void main(String[] args) {
    float[] numeros = leNumeros();
    float inicio = 0, fim = 1000;
    int n = 100;
    float[] histograma = new float[n];
    for (int i = 0; i < qtd; i++) {
      int pos = posicao(inicio, fim, n, numeros[i]);
      histograma[pos]++;
    }

  }

  public static int posicao(float inicio, float fim, int n, float numero) {
    int pos;
    if (numero < fim) {
      float delta = (fim - inicio) / n;
      pos = (int) (numero / delta);
    } else
      pos = n - 1;
    return pos;
  }

  public static float[] leNumeros() {
    float[] numeros = new float[10000];
    qtd = 0;
    // implementar captura de numeros
    //qtd++;
    return numeros;
  }
}
