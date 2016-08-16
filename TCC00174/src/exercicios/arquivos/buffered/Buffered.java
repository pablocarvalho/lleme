package exercicios.arquivos.buffered;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javadb.com
 */
public class Buffered {

  public void readFromFile(String filename) {

    File arquivo = new File(filename);
    BufferedInputStream bufferedInput = null;

    byte[] memoria = new byte[(int) arquivo.length()];

    try {
      bufferedInput = new BufferedInputStream(
              new FileInputStream(arquivo));

      bufferedInput.read(memoria, 0, (int) arquivo.length());

      System.out.println(new String(memoria));

    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      try {
        bufferedInput.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  /**
   * Prints some data to a file
   */
  public void writeToFile(String filename) {

    BufferedOutputStream bufferedOutput = null;

    try {

      //Construct the BufferedOutputStream object
      bufferedOutput = new BufferedOutputStream(
              new FileOutputStream(filename));

      //Start writing to the output stream
      bufferedOutput.write("Line one".getBytes());
      bufferedOutput.write("\n".getBytes()); //new line, you might want to use \r\n if you're on Windows
      bufferedOutput.write("Line two".getBytes());
      bufferedOutput.write("\n".getBytes());

      //prints the character that has the decimal value of 65
      bufferedOutput.write(65);

    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      //Close the BufferedOutputStream
      try {
        if (bufferedOutput != null) {
          bufferedOutput.flush();
          bufferedOutput.close();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Buffered obj = new Buffered();

    obj.writeToFile("myFile.txt");
    obj.readFromFile("myFile.txt");
  }
}
