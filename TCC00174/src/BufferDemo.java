
import java.io.*;

public class BufferDemo {

  public static void main(String[] arguments) {
    int start = 0;
    int finish = 255;
    if (arguments.length > 1) {
      start = Integer.parseInt(arguments[0]);
      finish = Integer.parseInt(arguments[1]);
    } else if (arguments.length > 0)
      start = Integer.parseInt(arguments[0]);
    ArgStream as = new ArgStream(start, finish);
    System.out.println("\nWriting: ");
    boolean success = as.writeStream();
    System.out.println("\nReading: ");
    boolean readSuccess = as.readStream();
  }
}
