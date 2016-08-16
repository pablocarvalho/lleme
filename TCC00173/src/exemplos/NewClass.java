package exemplos;

import java.util.Scanner;

public class NewClass {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    System.out.println("Entre com altura em metros.");
    float metros = in.nextFloat();
    int pes = (int) ((metros * 100) / 30.48);

    float pol = ((metros * 100) - (pes * 30.48f)) / 2.54f;
    System.out.println("pes: " + pes);
    System.out.println("pol: " + pol);


  }
}
