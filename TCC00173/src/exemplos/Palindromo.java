/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplos;

/**
 *
 * @author Luiz Leme
 */
public class Palindromo {

  public static void main(String[] args) {
    System.out.println(ePalindrome("abba"));
    String s1 = "a" + "b" + "c";
    String s2 = "abcd".substring(0, 3);

    if (s1 == s2)
      System.out.println("true");
    else {
      System.out.println("false");
      System.out.println(s1);
      System.out.println(s2);
    }
  }

  public static boolean ePalindrome(String palavra) {
    if (palavra == null || palavra.equals("") || palavra.length() == 1)
      return true;
    else if (palavra.charAt(0) != palavra.charAt(palavra.length() - 1))
      return false;
    else
      return ePalindrome(palavra.substring(1, palavra.length() - 1));
  }
}
