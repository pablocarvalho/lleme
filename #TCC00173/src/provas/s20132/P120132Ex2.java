package provas.s20132;

public class P120132Ex2 {

  public static void main(String[] args) {
    int n;
    double s;
    n = 10;
    s = 0;
    for (int i = 10; i <= n; i++)
      s += (Math.pow(2.0, i)) + 3.0;
    System.out.println(s);
  }
}
