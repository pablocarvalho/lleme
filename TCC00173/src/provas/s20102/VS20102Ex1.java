package provas.s20102;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class VS20102Ex1 {

  public static void main(String[] args) throws FileNotFoundException {
    InputStream input = new FileInputStream("salario.txt");
    Scanner in = new Scanner(input);
    float salario, freq[] = new float[10];
    int n, count = 0;
    while (in.hasNext()) {
      salario = in.nextFloat();
      count++;
      for (int i = 0; i < 10 && salario <= 5100; i++)
        if (salario <= (i + 1) * 510.0)
          freq[i]++;
    }
    in.close();
    if (count > 0)
      for (int i = 0; i < 10; i++)
        System.out.println("faixa " + i + " = " + freq[i] / count);

  }
}
