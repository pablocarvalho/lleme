package exercicios;

public class P320081Ex2 {

  public static void main(String[] args) {
    double x0 = 0, x1 = 1, y0 = 0, y1 = 1, dx, dy, yi, xj, volume = 0;
    int nx = 100, ny = 100;
    dx = Math.abs(x1 - x0) / nx;
    dy = Math.abs(y1 - y0) / ny;
    for (int i = 0; i < ny; i++) {
      yi = y1 - i * dy;
      for (int j = 0; j < nx; j++) {
        xj = x0 + j * dx;
        volume += dx * dy * f(xj, yi);
      }
    }

  }

  public static double f(double x, double y) {
    return 1;
  }
}
