package exercicios.backtracking;

import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ananmon
 */
public class Combinacoes {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here

    String string = JOptionPane.showInputDialog("Digite uma palavra sem letras repetidas");
    char[] s = string.toCharArray();
    string = JOptionPane.showInputDialog("Digite o tamanho da combinacao");
    int n = Integer.parseInt(string);

    gerarCombinacoes(s, 0, 0, s.length, n);
  }

  public static char[] copy(char[] s) {
    char[] temp = new char[s.length];
    for (int i = 0; i < s.length; i++)
      temp[i] = s[i];
    return temp;
  }

  public static void rot(char[] s, int pos) {
    char temp = s[pos];
    for (int i = pos; i < s.length - 1; i++)
      s[i] = s[i + 1];
    s[s.length - 1] = temp;
  }

  public static void print(char[] s, int k) {
    for (int i = 0; i < k; i++)
      System.out.print(s[i]);
    System.out.println();
  }

  private static void gerarCombinacoes(char[] s, int pos, int nrot, int n, int k) {
    if (pos == k) {
      System.out.print(pos + " " + nrot + " ");
      print(s, k);
    } else {
      char[] temp = copy(s);
      for (int i = 0; i < n - k + 1 - nrot; i++) {
        gerarCombinacoes(s, pos + 1, nrot + i, n, k);
        rot(temp, pos);
        s = copy(temp);
      }
    }
  }
}
