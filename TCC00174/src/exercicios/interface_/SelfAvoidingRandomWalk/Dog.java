package exercicios.interface_.SelfAvoidingRandomWalk;

public class Dog {

  private int posX, posY;

  Dog(int posX, int posY) {
    this.posX = posX;
    this.posY = posY;
  }

  public int getPosX() {
    return posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  public void move(int x, int y) {
    this.posX += x;
    this.posY += y;
  }

  public Coordinate randomWalk(Grid grid) {
    double r = Math.random();
    Coordinate coord = new Coordinate(posX, posY);

    if (r < 0.25 && !grid.getMarked(posX + 1, posY)) {
      coord.setXY(posX + 1, posY);
      move(1, 0);
    } else if (r < 0.50 && !grid.getMarked(posX - 1, posY)) {
      coord.setXY(posX - 1, posY);
      move(-1, 0);
    } else if (r < 0.75 && !grid.getMarked(posX, posY + 1)) {
      coord.setXY(posX, posY + 1);
      move(0, 1);
    } else if (r < 1.00 && !grid.getMarked(posX, posY - 1)) {
      coord.setXY(posX, posY - 1);
      move(0, -1);
    }
    return coord;
  }
}
