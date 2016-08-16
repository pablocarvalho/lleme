package exercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Scanner;

public class P120091Ex4 {

  public static void main(String[] args) throws FileNotFoundException {

    InputStream input = new FileInputStream(".\\dat\\sorteados.txt");
    Scanner in = new Scanner(input);
    float nota = 0, mediaMeninos = 0, mediaMeninas = 0, numMeninos = 0, numMeninas = 0;
    String sexo = null;
    while (in.hasNext()) {
      nota = in.nextFloat();
      sexo = in.next();
      if (sexo.equals("m")) {
        mediaMeninos += nota;
        numMeninos++;
      } else {
        mediaMeninas += nota;
        numMeninas++;
      }
    }
    mediaMeninos /= numMeninos;
    mediaMeninas /= numMeninas;
    if (mediaMeninos > mediaMeninas)
      System.out.println("A media dos meninos foi maior que a das meninas");
    else
      System.out.println("A media das meninas foi maior que a dos meninos");
    in.close();

  }
}
