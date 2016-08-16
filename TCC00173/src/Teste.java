
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Teste {

  public static void main(String[] args) {

    int[] vetor = {1, 9, 3, 2, 5, 6, 7, 8, 4};
    Arrays.sort(vetor);
    imprime(vetor);
    Arrays.fill(vetor, 4);
    imprime(vetor);
    
  }

  public static void imprime(int[] vet) {
    for (int i = 0; i < vet.length; i++)
      System.out.println(vet[i]);
  }
}
