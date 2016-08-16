package exemplos;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class LerNotas {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    OutputStream output = new FileOutputStream("saida.txt", false);
    OutputStreamWriter writer = new OutputStreamWriter(output);
    BufferedWriter bw = new BufferedWriter(writer);

    OutputStream output2 = new FileOutputStream("entrada2.txt", false);
    OutputStreamWriter writer2 = new OutputStreamWriter(output);
    BufferedWriter bw2 = new BufferedWriter(writer);

    InputStream input = new FileInputStream("entrada.txt");
    Scanner in = new Scanner(input);

    float soma = 0;
    int contador = 0;
    float nota;

    while (in.hasNext()) {
      contador++;
      nota = in.nextFloat();
      soma = soma + nota;
      bw2.write("" + nota);
    }
    bw.write("media=" + soma / contador);

    bw.close();
    input.close();

  }
}
