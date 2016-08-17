package exemplos;

import java.util.Scanner;

public class VolumeEsfera {

  public static void main(String[] args) {
    float raio;   /* raio da esfera */
    float vol;    /* volume calculado */
    Scanner in = new Scanner(System.in);
    System.out.println("Entre com o raio da esfera: ");
    raio = in.nextFloat();
    vol = (float) ((4.0 / 3.0) * Math.PI * Math.pow(raio, 3));
    System.out.println("Volume da esfera : " + vol);
  }
}
