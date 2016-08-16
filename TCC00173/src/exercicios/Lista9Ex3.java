package exercicios;

public class Lista9Ex3 {

  public static void main(String[] args) {
    String string = "abcrcha";
    System.out.println(ePalindromo(string, 0, string.length() - 1));
  }

  public static boolean ePalindromo(String string, int i, int j) {
    if (i > j)
      return true;
    return string.charAt(i) == string.charAt(j) && ePalindromo(string, ++i, --j);
  }
}
