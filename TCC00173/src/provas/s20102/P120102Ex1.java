package provas.s20102;

import java.util.Scanner;

public class P120102Ex1 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double volA, volB, volDesejado;
    double retiradoA, retiradoB;

    System.out.println("Informe volume de A, volume de B e volume desejado");
    volA = in.nextDouble();
    volB = in.nextDouble();
    volDesejado = in.nextDouble();

    if (volDesejado > volA * 0.8) {
      retiradoA = volA * 0.8;
      if ((volDesejado - retiradoA) > volB * 0.9)
        retiradoB = volB * 0.9;
      else
        retiradoB = volDesejado - retiradoA;
    } else {
      retiradoA = volDesejado;
      retiradoB = 0.0;
    }


    System.out.println("Devem ser extraidos " + retiradoA + " litros do reservatorio A");
    System.out.println("Devem ser extraidos " + retiradoB + " litros do reservatorio B");
    if (volDesejado > retiradoA + retiradoB)
      System.out.println("Falta obter " + (volDesejado - (retiradoA
              + retiradoB)) + " litros de agua");
  }
}
