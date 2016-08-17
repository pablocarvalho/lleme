/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

public class Lista5Ex1 {

  public static void main(String[] args) {
    System.out.println("o produto é iugual a:" + produto(0, 16));
  }

  public static int produto(int a, int b) {
    int c = 1;
    if ((a % 2) == 0)
      a++;
    for (; a <= b; a += 2)
      c = c * a;
    return c;
  }
}
