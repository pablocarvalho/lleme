
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teste {

  public static void main(String[] args) throws FileNotFoundException {
    String exp = "( CA + 4.5 ) * 3";

    String[] arr = exp.split(" ");
    for (int i = 0; i < arr.length; i++)
      System.out.println(arr[i]);

  }
}
