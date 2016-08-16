
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class ArgStream {

  int start = 0;
  int finish = 255;

  ArgStream(int st, int fin) {
    start = st;
    finish = fin;
  }

  boolean writeStream() {
    try {
      FileOutputStream file = new FileOutputStream("numbers.dat");
      BufferedOutputStream buff = new BufferedOutputStream(file);
      for (int out = start; out <= finish; out++) {
        buff.write(out);
        System.out.print(" " + out);
      }
      buff.close();
      return true;
    } catch (IOException e) {
      System.out.println("Exception: " + e.getMessage());
      return false;
    }
  }

  boolean readStream() {
    try {
      FileInputStream file = new FileInputStream("numbers.dat");
      BufferedInputStream buff = new BufferedInputStream(file);
      int in = 0;
      do {
        in = buff.read();
        if (in != -1)
          System.out.print(" " + in);
      } while (in != -1);
      buff.close();
      return true;
    } catch (IOException e) {
      System.out.println("Exception: " + e.getMessage());
      return false;
    }
  }
}
