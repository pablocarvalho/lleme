package provas.s20111;

public class Teste {

  public static void main(String[] args) {
    int i = 2, multiplo = 1, a = 15, b = 24;
    while (((a / i) > 1) || ((b / i) > 1)) {
      if (((a % i) == 0) && ((b % i) == 0)) {
        a = a / i;
        b = b / i;
        multiplo = i * multiplo;
        i = 1;
      } else if ((a % i) == 0) {
        a = a / i;
        multiplo = i * multiplo;
        i = 1;
      } else if ((b % i) == 0) {
        b = b / i;
        multiplo = i * multiplo;
        i = 1;
      }
      i++;
    }
    System.out.println(multiplo);
  }
}
