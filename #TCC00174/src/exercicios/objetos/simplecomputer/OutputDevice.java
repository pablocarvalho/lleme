/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Dispositivo de Entrada
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.objetos.simplecomputer;

class OutputDevice {

  /**
   * Escreve um numero inteiro.
   *
   * @param o numero a ser escrito.
   */
  public void writeInt(int value) {
    System.out.print(">>");
    System.out.println(value);
  }
}
