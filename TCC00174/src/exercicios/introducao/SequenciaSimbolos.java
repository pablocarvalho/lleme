package exercicios.introducao;

/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Sequencia de simbolos
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.util.Scanner;

public class SequenciaSimbolos {
  // Definicao dos estados

  public enum Estado {

    I, SO, CH, CC, DP
  };

  /**
   * Interpreta uma sequencia de simbolos.
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String args[]) {
    try {
      // I/o: pede ao usuario a sequencia de caracteres
      System.out.println("Digite a sequencia");
      Scanner s = new Scanner(System.in);
      String sequencia = s.nextLine();

      //Exibe a sequencia digitada
      System.out.println("A sequencia e:" + sequencia);

      int i = 0;
      Estado estado = Estado.I;
      while (i < sequencia.length()) {
        // Leitura do caracter atual
        char c = sequencia.charAt(i);

        switch (estado) {
          case I:
            if (c == 'A')
              estado = Estado.CH;
            else if (c == 'B')
              System.out.println("Chute lateral");
            break;
          case CH:
            if (c == 'A') {
              System.out.println("Chute circular");
              estado = Estado.I;
            } else if (c == 'B') {
              System.out.println("Dragon punch");
              estado = Estado.I;
            } else {
              System.out.println("Soco");
              estado = Estado.I;
            }
            break;
        }
        i++;
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e.toString());
    }
  }
}
