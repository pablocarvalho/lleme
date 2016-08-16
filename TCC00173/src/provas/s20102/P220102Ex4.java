package provas.s20102;

public class P220102Ex4 {

  public static void main(String[] args) {
    System.out.println(somaPares(2));
    System.out.println(somaPares2(2));
  }

  public static int somaPares(int n) {
    if (n > 0)
      if (n % 2 == 0)
        return n + somaPares(n - 1);
      else
        return 0 + somaPares(n - 1);
    return 0;
  }

  public static int somaPares2(int n) {
    int result = 0;
    if (n > 0)
      result += somaPares2(n - 1);
    if ((n % 2) == 0)
      result += n;
    return result;
  }
}
