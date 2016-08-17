package exercicios.interface_.SelfAvoidingRandomWalk;

/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Passeio Aleatorio: Coordenadas do grid
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class Coordinate {
  // Coordenadas x e y da celula do grid.

  private int x, y;

  /**
   * Construtor
   */
  Coordinate() {
  }

  ;

    /**
     * Construtor
     * 
     * @param x primeira coordenada da celula
     * @param y segunda coordenada da celula
     */
    Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Acesso a coordenada x
   *
   * @return valor da coordenada
   */
  public int getX() {
    return x;
  }

  /**
   * Acesso a coordenada y
   *
   * @return valor da coordenada
   */
  public int getY() {
    return y;
  }

  /**
   * Atribuicao da coordenada x
   *
   * @param x valor da coordenada
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Atribuicao da coordenada y
   *
   * @param y valor da coordenada
   */
  public void setY(int y) {
    this.y = y;
  }

  /**
   * Atribuicao simultanea das coordenadas x e y
   *
   * @param x valor da coordenada x
   * @param y valor da coordenada y
   */
  public void setXY(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
