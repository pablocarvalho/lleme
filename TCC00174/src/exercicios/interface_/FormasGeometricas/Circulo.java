package exercicios.interface_.FormasGeometricas;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Circulo
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Circulo extends Forma {

  private double raio; //> Raio do circulo

  /**
   * Construtor default.
   */
  Circulo() {
    this(0.0, 0.0, 1.0, new Cor(0, 0, 0));
  }

  Circulo(double posx, double posy) {
    this(posx, posy, 1.0, new Cor(0, 0, 0));
  }

  /**
   * Construtor.
   *
   * @param posx Posicao x do circulo
   * @param posy Posicao y do circulo
   * @param raio Raio do circulo
   */
  Circulo(double posx, double posy, double raio, Cor cor) {
    this.setPosx(posx);
    this.setPosy(posy);
    this.raio = raio;
    this.cor = cor;
    this.setArea(calcularArea());
  }

  /**
   * Acesso ao raio do circulo
   *
   * @return o raio do circulo
   */
  public double getRaio() {
    return raio;
  }

  /**
   * Atribuicao do raio do circulo
   *
   * @param raio o raio do circulo
   */
  public void setRaio(double raio) {
    this.raio = raio;
  }

  /**
   * Imprime os atributos do triangulo.
   */
  @Override
  public void print() {
    System.out.println("Circulo");
    System.out.println("Posicao em x:" + getPosx());
    System.out.println("Posicao em y:" + getPosy());
    System.out.println("Raio:" + raio);
    System.out.println("Area:" + getArea());
    System.out.println();
  }

  /**
   * Calcula a área do circulo.
   *
   * @return o valor calculado.
   */
  public double calcularArea() {
    return Math.PI * raio * raio;
  }

  /**
   * Metodo para o desenho do circulo
   *
   * @param comp2D Contexto de desenho
   */
  public void desenhar(Graphics2D comp2D) {
    Ellipse2D.Double ee = new Ellipse2D.Double(getPosx(), getPosy(), raio, raio);
    Color color = new Color(cor.getR(), cor.getG(), cor.getB());
    comp2D.setPaint(color);
    comp2D.fill(ee);
  }
}
