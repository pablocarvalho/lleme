/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Picos de um terreno
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.introducao;

public class PeaksTerrain {

  int width, height;
  private double[][] heights;
  int[][] peaks;

  /**
   * Construtor.
   *
   * @param w largura do terreno.
   * @param h comprimento do terreno.
   * @param heights matriz de valores.
   */
  PeaksTerrain(int w, int h, double[][] heights) {
    width = w;
    height = h;
    this.heights = heights;
  }

  /**
   * Acesso ao comprimento do terreno
   *
   * @return valor da variavel height
   */
  int getHeight() {
    return height;
  }

  /**
   * Acesso a largura do terreno
   *
   * @return valor da variavel width
   */
  int getWidth() {
    return width;
  }

  /**
   * Acesso a altura da ceula (i,j)
   *
   * @param i coordenada i da celula
   * @param j coordenada j da celula
   * @return valor da variavel heights[i][j]
   */
  double getHeightValue(int i, int j) {
    return heights[i][j];
  }

  /**
   * Calcula os Picos
   *
   * @param maskSize tamanho da mascara de busca
   */
  void findPeaks(int maskSize) {
    peaks = new int[width][height];

    int m = maskSize / 2;

    // Percorre as celulas na diracao i
    for (int i = m; i < height - m; i++)
      // Percorre as celulas na diracao j
      for (int j = m; j < width - m; j++) {

        // Le a altura da celula (i,j)
        double value = getHeightValue(i, j);
        // Inicializa 
        boolean isPeak = true;

        // Percorre os vizinhos
        for (int k = -m; k <= m && isPeak; k++)
          for (int l = -m; l <= m && isPeak; l++)
            // evita o teste na celula (i,j)
            if (k != 0 || l != 0)
              if (value <= getHeightValue(i + k, j + l))
                isPeak = false;
        // Armazena o resultado
        if (isPeak)
          peaks[i][j] = 1;
        else
          peaks[i][j] = 0;
      }
  }

  /**
   * Imprime os Picos
   */
  void printPeaks() {

    // Percorre a matriz
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++)
        System.out.print(peaks[i][j] + " ");
      System.out.println();
    }
  }
}
