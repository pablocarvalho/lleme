package provas.s20132;

public class P120132Ex1 {

  public static void main(String[] args) {
    System.out.println(b1ToB2(11, 8, 2));
  }

  public static int b1ToB2(int n, int b1, int b2) {
    return _10ToB(bTo10(n, b1), b2);
  }

  public static int _10ToB(int n, int b) {
    int digDir, pot, s;
    int _10ToB = 0;
    pot = 0;
    while (n > 0) {
      digDir = n % b;
      _10ToB = _10ToB + digDir * ((int) Math.pow(10, pot));
      n = n / b;
      pot = pot + 1;
    }
    return _10ToB;
  }

  public static int bTo10(int n, int b) {
    int digDir, pot;
    int bTo10 = 0;
    pot = 0;
    while (n > 0) {
      digDir = n % 10;
      bTo10 = bTo10 + digDir * ((int) Math.pow(b, pot));
      n = n / 10;
      pot = pot + 1;
    }
    return bTo10;
  }
}
