package exercicios.introducao;

/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Padrao de divisores
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class PadraoDivisores {

  /**
   * Imprime uma matriz NxN tal que: a_ij = * se i divide j ou j divide i
   *
   * @param args Argumentos de linha de comando
   */
  public static void main(String[] args) {
    try {
      // Recebe os argumentos da linha de comando
      int n = Integer.parseInt(args[0]);
      // Percorre as linhas da matriz
      for (int i = 1; i <= n; i++) {
        // Percorre as colunas da matriz
        for (int j = 1; j <= n; j++)
          // Testa se i e j sao divisores
          if ((i % j == 0) || (j % i == 0))
            System.out.print("* ");
          else
            System.out.print("  ");
        System.out.println(i);
      }
    } // Erro no numero de argumentos        
    catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e.toString());
    }
  }
}
