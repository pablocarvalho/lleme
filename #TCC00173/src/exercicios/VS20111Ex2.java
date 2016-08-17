/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

/**
 *
 * @author Luiz Leme
 */
public class VS20111Ex2 {

  public static void main(String[] args) {
    String texto = "afefa";
    System.out.println(ePalindromo(texto));
  }

  public static boolean ePalindromo(String texto) {
    if (texto.length() <= 1)
      return true;
    else {
      char c1 = texto.charAt(0);
      char c2 = texto.charAt(texto.length() - 1);
      String meio = texto.substring(1, texto.length() - 1);
      if (c1 == c2 && ePalindromo(meio))
        return true;
      else
        return false;
    }
  }
}
