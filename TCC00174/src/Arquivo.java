
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Arquivo {

  public static void main(String[] args) throws IOException {

    Throwable d = null;

    try {
      FileInputStream file = new FileInputStream("numbers.dat");
      Scanner in = new Scanner(file);
      int num1 = 0;
      float num2 = 0;

      OutputStream output = new FileOutputStream("numbers2.dat", false);
      OutputStreamWriter writer = new OutputStreamWriter(output);
      BufferedWriter bw = new BufferedWriter(writer);

      while (in.hasNext()) {
        num1 = in.nextInt();
        num2 = in.nextFloat();

        bw.write("" + num1 + " " + num2 + "\n");
      }
      bw.flush();
      bw.close();
      file.close();
    } catch (IOException e) {
    }
    
    metodo(4);

  }

  public static void metodo(int n) throws IOException {
    if (n > 1)
      throw new IOException();
  }
}
