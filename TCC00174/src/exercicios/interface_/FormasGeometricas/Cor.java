package exercicios.interface_.FormasGeometricas;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Cor
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.io.Serializable;

public class Cor implements Serializable {

  private int r, g, b; //> Valores de (r,g,b)

  /**
   * Construtor default.
   */
  public Cor(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Acesso ao canal vermelho
   *
   * @return o valor do vermelho
   */
  public int getR() {
    return r;
  }

  /**
   * Atribui o valor do canal vermelho
   *
   * @param r o valor do vermelho
   */
  public void setR(int r) {
    this.r = r;
  }

  /**
   * Acesso ao canal verde
   *
   * @return o valor do verde
   */
  public int getG() {
    return g;
  }

  /**
   * Atribui o valor do canal verde
   *
   * @param g o valor do verde
   */
  public void setG(int g) {
    this.g = g;
  }

  /**
   * Acesso ao canal azul
   *
   * @return o valor do azul
   */
  public int getB() {
    return b;
  }

  /**
   * Atribui o valor do canal azul
   *
   * @param g o valor do azul
   */
  public void setB(int b) {
    this.b = b;
  }

  /**
   * Armazena o estado atual em uma string
   *
   * @return a string com o valor dos canais
   */
  public String toStringValues() {

    return new String(String.valueOf(getR())
            + String.valueOf(getG())
            + String.valueOf(getB()));
  }

  /**
   * Imprime as cores.
   */
  public void print() {
    System.out.println("R: " + getR() + "G: " + getG() + "B:" + b);
  }
}
