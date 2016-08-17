/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Transformada de Haar
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.introducao;

public class HaarTransformMain {

  /**
   * Manipula um sinal usando a transformada de Haar.
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {

    // Sinal que sera transformado 
    double[] signal = {9.0, 7.0, 3.0, 5.0};

    // Sinal transformado
    double[] transformedSignal = HaarTransform.transform(signal);

    // Print do sinal transformado
    for (int i = 0; i < signal.length; i++)
      System.out.print(transformedSignal[i] + " ");
    System.out.println();

    // Inversa do sinal transformado
    double[] invTransformedSignal = HaarTransform.invTransform(transformedSignal);

    // Print da inversa do sinal transformado
    for (int i = 0; i < signal.length; i++)
      System.out.print(invTransformedSignal[i] + " ");
    System.out.println();
  }
}
