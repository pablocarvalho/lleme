package exercicios.rgb;

public class RGB extends Cor {

  private int r;
  private int g;
  private int b;

  private RGB() {
  }

  public RGB(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public CMYK converteCMYK() {
    int c = 0, m = 0, y = 0, k = 0;

    CMYK cmyk = new CMYK(c, m, y, k);
    return cmyk;
  }
}
