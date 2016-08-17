package exercicios;

import java.io.*;
import java.util.Scanner;

public class P220102Ex1 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    InputStream input = new FileInputStream("vetores.txt");
    Scanner in = new Scanner(input);
    double x, y, produto = 0;
    while (in.hasNext()) {
      x = in.nextDouble();
      y = in.nextDouble();
      produto += x * y;
    }
    in.close();

    OutputStream output = new FileOutputStream("", false);
    OutputStreamWriter out = new OutputStreamWriter(output);
    BufferedWriter writer = new BufferedWriter(out);

    writer.close();
  }
}
