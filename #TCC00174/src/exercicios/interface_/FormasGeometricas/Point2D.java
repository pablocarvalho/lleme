package exercicios.interface_.FormasGeometricas;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Ponto 2D
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class Point2D {

  private double x; //> Coordenada x do ponto
  private double y; //> Coordenada y do ponto

  /**
   * Construtor.
   *
   * @param x Coordenada x do ponto.
   * @param y Coordenada y do ponto.
   */
  Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Acesso a coordenada x do ponto.
   *
   * @return o valor da coordenada.
   */
  public double getX() {
    return x;
  }

  /**
   * Acesso a coordenada y do ponto.
   *
   * @return o valor da coordenada.
   */
  public double getY() {
    return y;
  }

  /**
   * Atribuicao do valor da coordenada x do ponto.
   *
   * @param x o valor da coordenada.
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Atribuicao do valor da coordenada y do ponto.
   *
   * @param y o valor da coordenada.
   */
  public void setY(double y) {
    this.y = y;
  }

  /**
   * Distancia entre dois pontos.
   *
   * @param p o ponto a ser testado.
   */
  public double dist(Point2D p) {
    double a = p.getX() - getX();
    double b = p.getY() - getY();

    return Math.sqrt(a * a + b * b);
  }
}
