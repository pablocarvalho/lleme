/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Simple Computer
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.objetos.simplecomputer;

import java.util.Scanner;

public class SimpleComputer {

  private CPU cpu;                  //> CPU do computador
  private Memory memory;             //> Memória do computador
  private InputDevice inputDevice;   //> Dispositivo de entrada
  private OutputDevice outputDevice; //> Dispositivo de saída

  /**
   * Construtor default.
   */
  SimpleComputer() {
    memory = new Memory();
    inputDevice = new InputDevice();
    outputDevice = new OutputDevice();
    cpu = new CPU(inputDevice, outputDevice, memory);
  }

  /**
   * Liga a máquina.
   */
  public void on() {
    System.out.println("SimpleComputer v. 1.0");
    dumpMemory();
    while (true) {
      System.out.print(">");
      readInput();
    }
  }

  /**
   * Desliga a máquina.
   */
  public void shutDown() {
    System.out.println("Shuting down...");
    System.exit(1);
  }

  /**
   * Lê uma entrada de dados.
   */
  public void readInput() {
    Scanner s = new Scanner(System.in);
    String input = s.next();

    if (input.compareTo("dump") == 0)
      dumpMemory();
    else if (input.compareTo("exit") == 0)
      shutDown();
    else if (input.compareTo("edit") == 0)
      editProgram(0);
    else if (input.compareTo("run") == 0)
      runProgram(0);
    else
      System.out.println("Invalid command");
  }

  /**
   * Lê uma palavra da memória.
   *
   * @param address Endereço da palavra.
   */
  public int readWord(int address) {

    int word = 0;
    boolean isInteger = false;
    do {
      Scanner s = new Scanner(System.in);
      try {
        word = s.nextInt();
        if (word >= Memory.MINWORD && word < Memory.MAXWORD)
          isInteger = true;
        else
          throw new Exception();

      } catch (Exception ex) {
        System.out.println("Illegal word");
        System.out.print("?" + address + " ");
      }
    } while (!isInteger);
    return word;
  }

  /**
   * Edita um programa.
   *
   * @param address Endereço da palavra.
   */
  public void editProgram(int address) {

    System.out.print("?" + address + " ");

    int word = readWord(address);

    while (word != Memory.MINWORD) {
      memory.setWord(address, word);
      address++;
      System.out.print("?" + address + " ");

      word = readWord(address);
    }
  }

  /**
   * Exibe os valores da memória.
   */
  public void dumpMemory() {

    System.out.print("   ");
    for (int i = 0; i <= 9; i++)
      System.out.printf("%4d ", i);
    System.out.println();

    for (int i = 0; i <= 9; i++) {
      System.out.printf("%2d ", i * 10);
      for (int j = 0; j <= 9; j++)
        System.out.printf("%4d ", memory.getWord(i * 10 + j));
      System.out.println();
    }
  }

  /**
   * Roda o programa armazenado na memória.
   *
   * @param address Endereço do programa
   */
  public void runProgram(int address) {
    cpu.run(address);
  }
}
