package exercicios.datastructures.InfixToPostfix;

import exercicios.datastructures.InfixToPostfix.arraystack.ArrayStack;
import java.util.Scanner;

/**
 * ***********************************************************************
 * Compilation: javac InfixToPostfix.java Execution: java InfixToPostfix
 * Dependencies: Stack.java StdIn.java
 *
 * Reads in an infix expression and outputs an equivalent postfix expression.
 *
 * Windows users: replace <Ctrl-d> with <Ctrl-z> so signify end of file.
 *
 * % java InfixToPostfix ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 * <Ctrl-d>
 * 2 3 4 + 5 6 * * +
 *
 * % java InfixToPostfix | java EvaluatePostfix ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) )
 * )
 * <Ctrl-d> 212
 *
 ************************************************************************
 */
public class InfixToPostfix {

  public static void main(String[] args) {
    ArrayStack stack = new ArrayStack();

    Scanner scan = new Scanner(args[0]);

    while (scan.hasNext()) {
      String s = scan.next();
      if (s.equals("+"))
        stack.push(s);
      else if (s.equals("-"))
        stack.push(s);
      else if (s.equals("*"))
        stack.push(s);
      else if (s.equals("/"))
        stack.push(s);
      else if (s.equals(")"))
        System.out.print(stack.topAndPop() + " ");
      else if (s.equals("("))
        System.out.print("");
      else if (!s.equals(" "))
        System.out.print(s + " ");
    }
    System.out.println();
  }
}
