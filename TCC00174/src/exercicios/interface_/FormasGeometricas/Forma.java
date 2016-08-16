package exercicios.interface_.FormasGeometricas;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Forma
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.awt.Graphics2D;

public abstract class Forma implements IComparavel, IDesenhavel {

  private double posx; //> Posicao x da forma
  private double posy; //> Posicao y da forma
  private double area; //> Area da forma
  protected Cor cor; //> Cor da forma

  /**
   * Acesso a coordenada x da forma.
   *
   * @return o valor da coordenada.
   */
  public double getPosx() {
    return posx;
  }

  /**
   * Acesso a coordenada y da forma.
   *
   * @return o valor da coordenada.
   */
  public double getPosy() {
    return posy;
  }

  /**
   * Atribui a coordenada x da forma.
   *
   * @param posx o valor da coordenada.
   */
  public void setPosx(double posx) {
    this.posx = posx;
  }

  /**
   * Atribui a coordenada y da forma.
   *
   * @param posy o valor da coordenada.
   */
  public void setPosy(double posy) {
    this.posy = posy;
  }

  /**
   * Acesso a area da forma.
   *
   * @return o valor da area.
   */
  public double getArea() {
    return area;
  }

  /**
   * Atribui a area da forma.
   *
   * @param area o valor da area.
   */
  public void setArea(double area) {
    this.area = area;
  }

  /**
   * Imprime os atributos da forma.
   */
  public void print() {
    System.out.println("Posicao em x:" + posx);
    System.out.println("Posicao em y:" + posy);
  }

  /**
   * Compara duas formas de acordo com a area.
   *
   * @param o Objeto a ser comparado
   */
  public int compararCom(IComparavel o) {

    Forma f = (Forma) o;
    if (getArea() < f.getArea())
      return -1;
    else if (getArea() > f.getArea())
      return 1;

    return 0;
  }

  /**
   * Metodo abstrato para o calculo da area
   */
  public abstract double calcularArea();

  /**
   * Metodo abstrato para o desenho da forma
   *
   * @param comp2D Contexto de desenho
   */
  public abstract void desenhar(Graphics2D comp2D);
}
