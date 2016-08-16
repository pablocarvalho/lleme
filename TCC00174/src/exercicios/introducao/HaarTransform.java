/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Transformada de Haar
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.introducao;

public class HaarTransform {

  /**
   * Decomposicao do sinal.
   *
   * @param c Sinal.
   * @param g Tamanho do sinal.
   */
  private static void decompose(double[] c, int g) {
    double[] w = new double[g];

    for (int i = 0; i < g / 2; i++) {
      w[i] = (c[2 * i] + c[2 * i + 1]) / 2;
      w[g / 2 + i] = (c[2 * i] - c[2 * i + 1]) / 2;
    }

    System.arraycopy(w, 0, c, 0, g);
  }

  /**
   * Calculo da transformacao.
   *
   * @param v Sinal.
   * @return Sinal transformado.
   */
  public static double[] transform(double[] v) {

    double[] c = new double[v.length];
    System.arraycopy(v, 0, c, 0, c.length);

    int g = c.length;

    while (g >= 2) {
      decompose(c, g);
      g /= 2;
    }

    return c;
  }

  /**
   * Reconstrucao do sinal.
   *
   * @param c Sinal.
   * @param g Tamanho do sinal.
   */
  private static void reconstruct(double[] c, int g) {
    double[] w = new double[g];

    for (int i = 0; i < g / 2; i++) {
      w[2 * i] = (c[i] + c[g / 2 + i]);
      w[2 * i + 1] = (c[i] - c[g / 2 + i]);
    }

    System.arraycopy(w, 0, c, 0, g);
  }

  /**
   * Calculo da transformacao inversa.
   *
   * @param v Sinal.
   * @return Sinal transformado.
   */
  public static double[] invTransform(double[] v) {

    double[] c = new double[v.length];
    System.arraycopy(v, 0, c, 0, c.length);

    int g = 2;

    while (g <= c.length) {
      reconstruct(c, g);
      g *= 2;
    }

    return c;

  }
}
