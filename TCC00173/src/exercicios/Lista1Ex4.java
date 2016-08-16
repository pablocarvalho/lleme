package exercicios;

public class Lista1Ex4 {

  public static void main(String[] args) {
    int a = 10;
    int b = 1;
    int c = 5;
    int d;
    if (b < a) {
      d = a;
      a = b;
      b = d;
    }
    if (c < b) {
      d = b;
      b = c;
      c = d;
    }
    if (b < a) {
      d = a;
      a = b;
      b = d;
    }

    System.out.println(a);
    System.out.println(c);
  }
}
