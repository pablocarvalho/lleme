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

public class Arquivos {

  public static void main(String[] args) throws FileNotFoundException, IOException {

    OutputStream output = new FileOutputStream("saida.txt", false);
    OutputStreamWriter writer = new OutputStreamWriter(output);
    BufferedWriter bw = new BufferedWriter(writer);

    InputStream input = new FileInputStream("entrada.txt");
    Scanner in = new Scanner(input);
    //ler primeiro
    input.close();

    input = new FileInputStream("entrada2.txt");
    in = new Scanner(input);
    //ler segundo
    input.close();

    float soma = 0, nota = 0;
    int contador = 0;
    String nome;
    while (in.hasNext()) {
      contador++;
      nota = in.nextFloat();
      soma = soma + nota;
    }
    bw.write("frase " + (soma / contador));

    bw.close();
    input.close();
  }
}
