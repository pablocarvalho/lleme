package exercicios.introducao;

/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Matriz de Hadamard
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import javax.swing.JOptionPane;

public class HadamardMain {

  /**
   * Constroi a matriz de Hadamard.
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {
    int n = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero potencia de 2"));

    try {
      // Constroi a matriz
      int[][] matrix = HadamardMatrix.build(n);

      //Imprime a matriz
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
          System.out.print(matrix[i][j] + " ");
        System.out.println();
      }

    } // Imprime a pilha de chamadas
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
