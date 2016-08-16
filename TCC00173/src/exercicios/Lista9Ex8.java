package exercicios;

public class Lista9Ex8 {

  public static void main(String[] args) {
    int numero = 756;
    System.out.println(Math.log(numero) / Math.log(2));
    System.out.println(pisoLog2(numero));
    System.out.println(Math.floor(Math.log(numero) / Math.log(2)));
    System.out.println(Math.floor(Math.log10(numero) / Math.log10(2)));
  }

  public static double pisoLog2(double n) {
    if (n < 2)
      return 0;
    else
      return 1 + pisoLog2(n / 2);
  }
}
