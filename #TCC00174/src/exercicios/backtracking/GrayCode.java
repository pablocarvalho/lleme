package exercicios.backtracking;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anselmo
 */
public class GrayCode {

  public static void GrayCode(int n, String s, boolean forward) {
    if (n == 0)
      System.out.println(s);
    else {
      int c;
      if (forward == true)
        c = 0;
      else
        c = 1;
      GrayCode(n - 1, s + c, true);
      GrayCode(n - 1, s + (1 - c), false);
    }
  }

  public static void main(String[] args) {
    GrayCode(3, "", true);
  }
}
