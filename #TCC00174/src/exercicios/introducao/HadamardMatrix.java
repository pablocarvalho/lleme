package exercicios.introducao;

/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Matriz de Hadamard
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class HadamardMatrix {

  /**
   * Testa se o numero n e potencia de 2
   *
   * @param n Tamanho da matriz.
   * @return verdadeiro se n e potencia de 2
   */
  private static boolean isPowerOf2(int n) {
    int rest = 0;
    while (n > 1) {
      rest = n % 2;
      if (rest == 1)
        return false;
      n /= 2;
    }

    return true;
  }

  /**
   * Constroi a matriz de Radamard
   *
   * @param n Tamanho da matriz.
   */
  public static int[][] build(int n) throws HadamardException {
    // Declaracao da matriz
    int[][] matrix = null;

    //Testa o tamanho
    if ((!isPowerOf2(n)) || (n < 1)) {
      HadamardException ex = new HadamardException();
      throw ex;
    } else {
      matrix = new int[n][n];
      matrix[0][0] = 1;

      // Hadamard de ordem 1
      int k = 1;
      System.out.println("Ordem 1");
      System.out.println(matrix[0][0]);

      // Construcao da matriz de ordem n
      while (k < n) {
        k = k * 2;
        for (int i = 0; i < k / 2; i++)
          for (int j = 0; j < k / 2; j++) {
            matrix[i + k / 2][j] = matrix[i][j];
            matrix[i][j + k / 2] = matrix[i][j];
            matrix[i + k / 2][j + k / 2] = 1 - matrix[i][j];
          }
      }
    }

    return matrix;
  }
}
