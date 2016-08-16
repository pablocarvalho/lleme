/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Dispositivo de Entrada
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.objetos.simplecomputer;

import java.io.InputStream;
import java.util.Scanner;

class InputDevice {

  private Scanner s;      //> Scanner de dados
  private InputStream is; //> Fluxo de entrada de dados

  /**
   * Construtor default.
   */
  InputDevice() {
    this.is = System.in;
    s = new Scanner(is);
  }

  /**
   * Construtor.
   *
   * @param is Fluxo de entrada de dados
   */
  InputDevice(InputStream is) {
    this.is = is;
  }

  /**
   * Le um numero inteiro.
   *
   * @return o numero lido.
   */
  public int readInt() {
    System.out.print(">>");
    return s.nextInt();
  }
}
