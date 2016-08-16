package exercicios.backtracking.curvadehilbert;

import java.awt.Graphics2D;

public class CurvaDeHilbert {

  int level;
  int lineSize;
  int width;
  int height;
  int x0, y0;

  CurvaDeHilbert(int level, int width, int height) {
    this.level = level;
    this.width = width;
    this.height = height;
    lineSize = width / (int) Math.pow(2, level);

  }

  void lineRight(Graphics2D g) {

    g.drawLine(x0, y0, x0 + lineSize, y0);
    x0 = x0 + lineSize;
  }

  void lineLeft(Graphics2D g) {

    g.drawLine(x0, y0, x0 - lineSize, y0);
    x0 = x0 - lineSize;
  }

  void lineUp(Graphics2D g) {

    g.drawLine(x0, y0 - lineSize, x0, y0);
    y0 = y0 - lineSize;
  }

  void lineDown(Graphics2D g) {

    g.drawLine(x0, y0 + lineSize, x0, y0);
    y0 = y0 + lineSize;
  }

  void A(int n, Graphics2D g) {
    if (n > 0) {
      D(n - 1, g);
      lineLeft(g);
      A(n - 1, g);
      lineDown(g);
      A(n - 1, g);
      lineRight(g);
      B(n - 1, g);
    }
  }

  void B(int n, Graphics2D g) {
    if (n > 0) {
      C(n - 1, g);
      lineUp(g);
      B(n - 1, g);
      lineRight(g);
      B(n - 1, g);
      lineDown(g);
      A(n - 1, g);
    }
  }

  void C(int n, Graphics2D g) {
    if (n > 0) {
      B(n - 1, g);
      lineRight(g);
      C(n - 1, g);
      lineUp(g);
      C(n - 1, g);
      lineLeft(g);
      D(n - 1, g);
    }
  }

  void D(int n, Graphics2D g) {
    if (n > 0) {
      A(n - 1, g);
      lineDown(g);
      D(n - 1, g);
      lineLeft(g);
      D(n - 1, g);
      lineUp(g);
      C(n - 1, g);
    }
  }

  public void draw(Graphics2D g) {
    y0 = lineSize / 2;
    x0 = width - lineSize / 2;
    A(level, g);
  }
}
