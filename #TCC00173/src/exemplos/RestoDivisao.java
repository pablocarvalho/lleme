package exemplos;

public class RestoDivisao {

  public static void main(String[] args) {
    System.out.println(resto(13, 7));
  }

  public static int resto(int x, int y) {
    if (x < y)
      return x;
    else
      return resto(x - y, y);
  }
}
