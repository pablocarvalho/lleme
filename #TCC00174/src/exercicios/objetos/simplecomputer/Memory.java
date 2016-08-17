/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Memoria
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.objetos.simplecomputer;

public class Memory {

  public final static int MINWORD = -9999; //> Menor valor inteiro
  public final static int MAXWORD = 9999; //> Maior valor inteiro
  private static final int MAXMEMORY = 100; //> Tamanho da memoria
  private int[] words;

  /**
   * Construtor default.
   */
  Memory() {
    words = new int[MAXMEMORY];
    for (int i = 0; i < MAXMEMORY; i++)
      words[i] = 0;
  }

  /**
   * Adiciona uma palavra a memoria.
   *
   * @param address Endereco de memoria.
   * @param value Valor a ser amazenado.
   */
  public void setWord(int address, int value) {
    words[address] = value;
  }

  /**
   * Lê uma palavra da memoria.
   *
   * @param address Endereco de memoria.
   * @return o valor a ser amazenado.
   */
  public int getWord(int address) {
    return words[address];
  }
}
