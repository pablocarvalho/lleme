package exercicios.backtracking;

import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anselmo
 */
public class Permutacao {

  public static void main(String[] args) {
    permuteString("", "String");

    int a = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de a"));
    int b = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de b"));

    int i = 1;
    boolean ehPermutacao = true;
    while ((i <= 9) && (ehPermutacao)) {
      int numDigitosA = ContaDigitos(a, i);
      int numDigitosB = ContaDigitos(b, i);
      if (numDigitosA != numDigitosB)
        ehPermutacao = false;
      i++;
    }

    String mensagem;
    if (ehPermutacao)
      mensagem = a + " e permutacao de " + b;
    else
      mensagem = a + " nao e permutacao de  " + b;

    JOptionPane.showMessageDialog(null, mensagem);
  }

  public static void permuteString(String beginningString, String endingString) {
    if (endingString.length() <= 1)
      System.out.println(beginningString + endingString);
    else
      for (int i = 0; i < endingString.length(); i++)
        try {
          String newString = endingString.substring(0, i) + endingString.substring(i + 1);

          permuteString(beginningString + endingString.charAt(i), newString);
        } catch (StringIndexOutOfBoundsException exception) {
          exception.printStackTrace();
        }
  }

  private static int ContaDigitos(int a, int i) {
    int numOcorrencias = 0;
    while (a > 0) {
      if (a % 10 == i)
        numOcorrencias++;
      a /= 10;
    }
    return numOcorrencias;
  }
}
