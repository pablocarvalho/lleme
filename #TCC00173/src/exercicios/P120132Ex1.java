package exercicios;

public class P120132Ex1 {

  public static void main(String[] args) {
    System.out.println(b1ParaB2(123, 10, 8));
  }

  public static int b1ParaB2(int n, int b1, int b2) {
    return _10ParaB2(b1Para10(n, b1), b2);
  }

  public static int b1Para10(int n, int b1) {
    int digitos = ((int) Math.log10(n)) + 1;
    int numero = 0;
    int digito;
    for (int i = 0; i < digitos; i++) {
      digito = n % 10;
      numero += digito * Math.pow(b1, i);
      n /= 10;
    }
    return numero;
  }

  public static int _10ParaB2(int n, int b2) {
    int digitos = ((int) Math.log10(n)) + 1;
    int numero = 0;
    int digito;
    for (int i = 0; i < digitos; i++) {
      numero += (n % b2) * Math.pow(10, i);
      n /= b2;
    }
    return numero;
  }
}
