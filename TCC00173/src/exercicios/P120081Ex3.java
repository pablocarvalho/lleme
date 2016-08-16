package exercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class P120081Ex3 {

  public static void main(String[] args) throws FileNotFoundException {
    InputStream input = new FileInputStream(".\\dat\\vertices.txt");
    Scanner in = new Scanner(input);
    float xi, yi, x0 = 0, y0 = 0, xAnt = 0, yAnt = 0, perimetro = 0;
    if (in.hasNext()) {
      x0 = xAnt = in.nextFloat();
      y0 = yAnt = in.nextFloat();
    }
    while (in.hasNext()) {
      xi = in.nextFloat();
      yi = in.nextFloat();
      in.nextLine();
      perimetro += distancia(xAnt, yAnt, xi, yi);
      xAnt = xi;
      yAnt = yi;
    }
    perimetro += distancia(xAnt, yAnt, x0, y0);
    in.close();
  }

  public static float distancia(float x1, float y1, float x2, float y2) {
    float distancia;
    distancia = (float) Math.sqrt(
            Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    return distancia;
  }
}
