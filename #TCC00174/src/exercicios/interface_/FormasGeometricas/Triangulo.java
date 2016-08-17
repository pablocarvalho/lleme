package exercicios.interface_.FormasGeometricas;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Triangulo
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.awt.Color;
import java.awt.Graphics2D;

public class Triangulo extends Forma {

  private double a, b, c; //> Lados do triangulo
  private Point2D p0, p1, p2; //> Vertices do triangulo 

  /**
   * Construtor.
   *
   * @param posx Posicao x do triangulo
   * @param posy Posicao y do triangulo
   * @param p0 Primeiro vertice do triangulo
   * @param p1 Segundo vertice do triangulo
   * @param p2 Terceiro vertice do triangulo
   * @param cor Cor do triangulo
   */
  Triangulo(double posx, double posy, Point2D p0, Point2D p1, Point2D p2, Cor cor) {
    this.setPosx(posx);
    this.setPosy(posy);
    this.p0 = p0;
    this.p1 = p1;
    this.p2 = p2;
    this.a = p0.dist(p1);
    this.b = p0.dist(p2);
    this.c = p1.dist(p2);
    this.cor = cor;
    this.setArea(calcularArea());
  }

  /**
   * Acesso a um dos lados do triangulo
   *
   * @return o valor do segmento
   */
  public double getA() {
    return a;
  }

  /**
   * Acesso a um dos lados do triangulo
   *
   * @return o valor do segmento
   */
  public double getB() {
    return b;
  }

  /**
   * Acesso a um dos lados do triangulo
   *
   * @return o valor do segmento
   */
  public double getC() {
    return c;
  }

  /**
   * Atribuicao do valor de um dos lados do triangulo
   *
   * @param a o tamanho do segmento
   */
  public void setA(double a) {
    this.a = a;
  }

  /**
   * Atribuicao do valor de um dos lados do triangulo
   *
   * @param b o tamanho do segmento
   */
  public void setB(double b) {
    this.b = b;
  }

  /**
   * Atribuicao do valor de um dos lados do triangulo
   *
   * @param c o tamanho do segmento
   */
  public void setC(double c) {
    this.c = c;
  }

  /**
   * Imprime os atributos do triangulo.
   */
  @Override
  public void print() {
    System.out.println("Triangulo");
    System.out.println("Posicao em x:" + getPosx());
    System.out.println("Posicao em y:" + getPosy());
    System.out.println("Lado a:" + a);
    System.out.println("Lado b:" + b);
    System.out.println("Lado c:" + c);
    System.out.println("Area:" + getArea());
    System.out.println();
  }

  /**
   * Calcula a área do triangulo.
   *
   * @return o valor calculado.
   */
  public double calcularArea() {
    double s = (a + b + c) / 2.0;
    return Math.sqrt(s * (s - a) * (s - b) * (s - c));
  }

  /**
   * Metodo para o desenho do triangulo
   *
   * @param comp2D Contexto de desenho
   */
  public void desenhar(Graphics2D comp2D) {

    java.awt.Polygon polygon = new java.awt.Polygon();

    polygon.addPoint((int) p0.getX(), (int) p0.getY());
    polygon.addPoint((int) p1.getX(), (int) p1.getY());
    polygon.addPoint((int) p2.getX(), (int) p2.getY());


    Color color = new Color(cor.getR(), cor.getG(), cor.getB());
    comp2D.setPaint(color);

    comp2D.translate(getPosx(), getPosy());
    comp2D.fill(polygon);
  }
}
