package exemplos;

public class Contagem {

  public static void main(String[] args) {

    int i = 9;
    for (i = 0; i < 10; i += 1)
      System.out.println(i);
  }

  public static boolean primo(int n) {
    int i = 2;
    while (i < n) {
      if ((n % i) == 0)
        return false;
      i++;
    }
    return true;
  }
}
