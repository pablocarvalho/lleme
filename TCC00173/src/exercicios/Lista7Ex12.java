package exercicios;

public class Lista7Ex12 {

  public static void main(String[] args) {
    int[] histograma = histograma();
    String[][] grafico = new String[histograma.length][max(histograma)];
    inicializar(grafico);
    String[][] novo = null;
    for (int i = 0; i < histograma.length; i++) {
      geraBarra(histograma[i], grafico[i]);
      novo = transpor(grafico);
    }
    imprimir(novo);
  }

  public static int[] histograma() {
    int[] histograma = {5, 6, 7, 1, 3, 10};
    return histograma;
  }

  private static void geraBarra(int i, String[] barra) {
    for (int j = 0; j < i; j++)
      barra[j] = "*";
  }

  private static int max(int[] histograma) {
    int max = histograma[0];
    for (int i = 1; i < histograma.length; i++)
      if (histograma[i] > max)
        max = histograma[i];
    return max;
  }

  private static String[][] transpor(String[][] grafico) {
    String[][] novo = new String[grafico[0].length][grafico.length];
    inicializar(novo);
    for (int i = 0; i < grafico.length; i++)
      for (int j = 0; j < grafico[0].length; j++)
        novo[novo.length - j - 1][i] = grafico[i][j];
    return novo;
  }

  private static void imprimir(String[][] grafico) {
    for (int i = 0; i < grafico.length; i++) {
      for (int j = 0; j < grafico[0].length; j++)
        System.out.print(grafico[i][j] + " ");
      System.out.println("");
    }
  }

  private static void inicializar(String[][] grafico) {
    for (int i = 0; i < grafico.length; i++)
      for (int j = 0; j < grafico[0].length; j++)
        grafico[i][j] = " ";
  }
}
