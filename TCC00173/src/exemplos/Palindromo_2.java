package exemplos;

public class Palindromo_2 {

  public static void main(String[] args) {
    System.out.println(palindromo("!# 3 #!", 0));
  }

  public static boolean palindromo(String texto, int n) {

    if (texto.length() <= 1 || n >= texto.length() / 2)
      return true;
    else if (texto.charAt(n) == texto.charAt(texto.length() - 1 - n)
            && palindromo(texto, n + 1))
      return true;
    return false;

  }
}
