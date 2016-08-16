package exercicios.backtracking.passeioCavalo;

public class Casa {

  private int x, y;
  private boolean valid = false;

  public Casa(int x, int y) {
    if (x >= 0 && x < 8 && y >= 0 && y < 8) {
      this.x = x;
      this.y = y;
      this.valid = true;
    } else
      this.valid = false;
  }

  public boolean isValid(int[][] tabuleiro) {
    if (this.valid && (tabuleiro[this.x][this.y] == 0))
      return true;
    else
      return false;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public String toString() {
    return "[" + this.x + "][" + this.y + "]";
  }
}
