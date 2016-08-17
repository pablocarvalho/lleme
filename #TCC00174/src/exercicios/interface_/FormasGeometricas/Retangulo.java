package exercicios.interface_.FormasGeometricas;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Retangulo
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Retangulo extends Forma {

  private double largura, altura; //> Lados do retangulo

  /**
   * Construtor default.
   */
  Retangulo() {
    this(0.0, 0.0, 1.0, 1.0, new Cor(0, 0, 0));
  }

  /**
   * Construtor.
   *
   * @param posx Posicao x do retangulo
   * @param posy Posicao y do retangulo
   * @param largura Largura do retangulo
   * @param altura Altura do retangulo
   * @param cor Cor do retangulo
   */
  Retangulo(double posx, double posy, double largura, double altura, Cor cor) {
    this.setPosx(posx);
    this.setPosy(posy);
    this.largura = largura;
    this.altura = altura;
    this.setArea(calcularArea());
    this.cor = cor;
  }

  /**
   * Acesso a largura do retangulo
   *
   * @return o valor do segmento
   */
  public double getLargura() {
    return largura;
  }

  /**
   * Acesso altura do retangulo
   *
   * @return o valor do segmento
   */
  public double getAltura() {
    return altura;
  }

  /**
   * Atribuicao da largura do retangulo
   *
   * @param a o tamanho do segmento
   */
  public void setLargura(double largura) {
    this.largura = largura;
  }

  /**
   * Atribuicao da altura do retangulo
   *
   * @param a o tamanho do segmento
   */
  public void setAltura(double altura) {
    this.altura = altura;
  }

  /**
   * Imprime os atributos do triangulo.
   */
  @Override
  public void print() {
    System.out.println("Retangulo");
    System.out.println("Posicao em x:" + getPosx());
    System.out.println("Posicao em y:" + getPosy());
    System.out.println("Largura:" + largura);
    System.out.println("Altura:" + altura);
    System.out.println("Area:" + getArea());
    System.out.println();
  }

  /**
   * Calcula a área do retangulo.
   *
   * @return o valor calculado.
   */
  public double calcularArea() {
    return largura * altura;
  }

  /**
   * Metodo para o desenho do retangulo
   *
   * @param comp2D Contexto de desenho
   */
  public void desenhar(Graphics2D comp2D) {

    Rectangle2D.Double re = new Rectangle2D.Double(getPosx(), getPosy(),
            largura, altura);
    Color color = new Color(cor.getR(), cor.getG(), cor.getB());
    comp2D.setPaint(color);

    comp2D.fill(re);
  }
}
