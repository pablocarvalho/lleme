package exercicios.interface_.SelfAvoidingRandomWalk;

/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Passeio Aleatorio: Coordenadas do grid
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Grid implements Drawable {

  private int cellHeight = 10;
  private int cellWidth = 10;
  private int width, height;
  private boolean[][] marked;

  Grid(int width, int height) {
    this.width = width;
    this.height = height;
    cellHeight = 10;
    cellWidth = 10;
    marked = new boolean[width][height];
  }

  public void draw(Graphics2D comp2D) {
    Rectangle rect = comp2D.getClipBounds();

    int cx = (rect.x + rect.width / 2);
    int cy = (rect.y + rect.height / 2);

    int pixelWidth = width * cellHeight;
    int pixelHeight = height * cellWidth;

    int x = cx - pixelWidth / 2;
    int y = cy - pixelHeight / 2;

    for (int i = 0; i < height + 1; i++) {
      int y0 = y + i * cellHeight;
      comp2D.drawLine(x, y0, x + pixelWidth, y0);
    }

    for (int j = 0; j < width + 1; j++) {
      int x0 = x + j * cellWidth;
      comp2D.drawLine(x0, y, x0, y + pixelHeight);
    }


    for (int i = 0; i < height; i++)
      for (int j = 0; j < width; j++)
        if (marked[i][j])
          drawCell(comp2D, i, j);
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public boolean getMarked(int i, int j) {
    return this.marked[i][j];
  }

  public void setMarked(int i, int j) {
    this.marked[i][j] = true;
  }

  public void resetMarked() {
    for (int i = 0; i < height; i++)
      for (int j = 0; j < width; j++)
        marked[i][j] = false;
  }

  public void drawCell(Graphics2D comp2D, int i, int j) {
    Rectangle rect = comp2D.getClipBounds();
    int cx = (rect.x + rect.width / 2);
    int cy = (rect.y + rect.height / 2);

    int pixelWidth = width * cellHeight;
    int pixelHeight = height * cellWidth;

    int x = cx - pixelWidth / 2;
    int y = cy - pixelHeight / 2;

    int x0 = x + i * cellWidth;
    int y0 = y + j * cellHeight;

    rect = new Rectangle(x0 + 2, y0 + 2, cellWidth - 3, cellHeight - 3);

    comp2D.fill(rect);
  }
}
