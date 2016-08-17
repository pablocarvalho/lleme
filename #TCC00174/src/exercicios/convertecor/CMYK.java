/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.convertecor;

/**
 *
 * @author Luiz Leme
 */
public class CMYK extends Cor {

  private int c, m, y, k;

  public CMYK(int c, int m, int y, int k) {
    this.c = c;
    this.m = m;
    this.y = y;
    this.k = k;
  }

  public RGB toRGB() {
    if (c == 0 && m == 0 && y == 0 && k == 1)
      return new RGB(0, 0, 0);

    return null;
  }

  /**
   * @return the c
   */
  public int getC() {
    return c;
  }

  /**
   * @param c the c to set
   */
  public void setC(int c) {
    this.c = c;
  }

  /**
   * @return the m
   */
  public int getM() {
    return m;
  }

  /**
   * @param m the m to set
   */
  public void setM(int m) {
    this.m = m;
  }

  /**
   * @return the y
   */
  public int getY() {
    return y;
  }

  /**
   * @param y the y to set
   */
  public void setY(int y) {
    this.y = y;
  }

  /**
   * @return the k
   */
  public int getK() {
    return k;
  }

  /**
   * @param k the k to set
   */
  public void setK(int k) {
    this.k = k;
  }

  @Override
  public Cor converte(Cor c) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
