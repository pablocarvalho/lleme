package provas.s20121;

import java.io.*;
import java.util.Scanner;

public class P120121Ex4 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    OutputStream output = new FileOutputStream("./dat/saida.txt", false);
    OutputStreamWriter writer = new OutputStreamWriter(output);
    BufferedWriter bw = new BufferedWriter(writer);

    InputStream input1 = new FileInputStream("./dat/numeros1.txt");
    Scanner in1 = new Scanner(input1);

    InputStream input2 = new FileInputStream("./dat/numeros2.txt");
    Scanner in2 = new Scanner(input2);

    int n1 = 0, n2 = 0;
    boolean n1Lido = false, n2Lido = false;

    while (in1.hasNext() || in2.hasNext()) {
      if (!n1Lido && in1.hasNext()) {
        n1 = in1.nextInt();
        n1Lido = true;
      }
      if (!n2Lido && in2.hasNext()) {
        n2 = in2.nextInt();
        n2Lido = true;
      }
      if ((n1Lido && n2Lido && n1 < n2) || (n1Lido && !n2Lido)) {
        bw.write("" + n1 + "\n");
        n1Lido = false;
      } else if (n2Lido) {
        bw.write("" + n2 + "\n");
        n2Lido = false;
      }
    }

    in1.close();
    in2.close();
    bw.close();
  }
}
