package exercicios.interface_.FormasGeometricas;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Colecao de Formas
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.awt.Graphics2D;

public class ColecaoFormas {

  private int numFormas; //> Numero de formas
  private Forma[] formas; //> Array de formas 

  /**
   * Construtor.
   *
   * @param n Numero maximo de formas
   */
  ColecaoFormas(int n) {
    formas = new Forma[n];
    numFormas = 0;
  }

  /**
   * Adiciona uma forma a colecao
   *
   * @param f A forma a ser adicionada
   */
  public void adicionarForma(Forma f) {
    try {
      formas[numFormas++] = f;
    } catch (ArrayIndexOutOfBoundsException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Acesso ao numero de formas
   *
   * @return o numero de formas na colecao
   */
  public int getNumFormas() {
    return numFormas;
  }

  /**
   * Acesso ao conjunto de formas
   *
   * @return a colecao de formas
   */
  public Forma[] getFormas() {
    return formas;
  }

  /**
   * Imprimir as informações das formas
   */
  public void imprimirInfo() {
    for (int i = 0; i < numFormas; i++)
      formas[i].print();
  }

  /**
   * Desenha as formas
   *
   * @param comp2D Contexto gráfico
   */
  public void desenhar(Graphics2D comp2D) {
    for (int i = 0; i < numFormas; i++)
      formas[i].desenhar(comp2D);
  }
}
