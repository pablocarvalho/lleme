package exercicios;

public class Lista9Ex3_2 {

  public static void main(String[] args) {
    String texto = " A BEEB A ";
    System.out.println(ePalindromo(texto, 0));
  }

  public static boolean ePalindromo(String texto, int pos) {
    if (pos >= texto.length() / 2)
      return true;
    else if (texto.charAt(pos) == texto.charAt(texto.length() - 1 - pos)
            && ePalindromo(texto, pos + 1))
      return true;
    else
      return false;

  }
}
