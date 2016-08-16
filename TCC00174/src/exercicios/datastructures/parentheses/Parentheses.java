package exercicios.datastructures.parentheses;

import exercicios.datastructures.parentheses.arraystack.ArrayStack;

/**
 * ***********************************************************************
 * Compilation: javac Parentheses.java Execution: java Parentheses < file.txt
 * Dependencies: StdIn.java Stack.java
 *
 * Reads in a text file and checks to see if the paretheses, curly braces, and
 * square brackets are balanced.
 *
 * % java java Parentheses [()]{}{[()()]()} true
 *
 * % java Parentheses [(]) false
 *
 ************************************************************************
 */
public class Parentheses {

  private static final char L_PAREN = '(';
  private static final char R_PAREN = ')';
  private static final char L_BRACE = '{';
  private static final char R_BRACE = '}';
  private static final char L_BRACKET = '[';
  private static final char R_BRACKET = ']';

  public static boolean isBalanced(String s) {
    ArrayStack stack = new ArrayStack();
    for (int i = 0; i < s.length(); i++)
      if (s.charAt(i) == L_PAREN)
        stack.push(L_PAREN);
      else if (s.charAt(i) == L_BRACE)
        stack.push(L_BRACE);
      else if (s.charAt(i) == L_BRACKET)
        stack.push(L_BRACKET);
      else if (s.charAt(i) == R_PAREN) {
        if (stack.isEmpty())
          return false;
        if ((Character) stack.pop() != L_PAREN)
          return false;
      } else if (s.charAt(i) == R_BRACE) {
        if (stack.isEmpty())
          return false;
        if ((Character) stack.pop() != L_BRACE)
          return false;
      } else if (s.charAt(i) == R_BRACKET) {
        if (stack.isEmpty())
          return false;
        if ((Character) stack.pop() != L_BRACKET)
          return false;
      } // ignore all other characters
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String s = args[0];
    System.out.println(s + " ----> " + isBalanced(s));
  }
}
