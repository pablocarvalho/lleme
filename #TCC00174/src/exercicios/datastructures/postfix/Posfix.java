package exercicios.datastructures.postfix;

import exercicios.datastructures.postfix.arraystack.ArrayStack;
import java.util.Scanner;

/**
 * ***********************************************************************
 * Compilation: javac Postfix.java Execution: java Postfix < file.txt
 * Dependencies: Stack.java
 *
 * Evaluates postfix expresions using a stack.
 *
 * Windows users: replace <Ctrl-d> with
 * <Ctrl-z> to signify end of file.
 *
 * % java Postfix 3 4 5 +
 *
 * <Ctrl-d>
 * 27
 *
 * % java Postfix 1 2 3 4 5 * + 6 * * +
 * <Ctrl-d>
 * 277
 *
 * % java Postfix 7 16 16 16 * * * 5 16 16 * * 3 16 * 1 + + +
 * <Ctrl-d>
 * 30001
 *
 * % java Postfix 7 16 * 5 + 16 * 3 + 16 * 1 +
 * <Ctrl-d>
 * 30001
 *
 * Known bugs ---------- - No error checking - assumes input is legal postfix
 * expression. - All token must be separated by whitespace, e.g., 1 5+ is
 * illegal.
 *
 ************************************************************************
 */
public class Posfix {

  public static void main(String[] args) {
    ArrayStack stack = new ArrayStack();

    Scanner scan = new Scanner(args[0]);

    while (scan.hasNext()) {
      String s = scan.next();
      if (s.equals("+"))
        stack.push((Integer) stack.topAndPop() + (Integer) stack.topAndPop());
      else if (s.equals("-"))
        stack.push((Integer) stack.topAndPop() - (Integer) stack.topAndPop());
      else if (s.equals("*"))
        stack.push((Integer) stack.topAndPop() * (Integer) stack.topAndPop());
      else if (s.equals("/"))
        stack.push((Integer) stack.topAndPop() / (Integer) stack.topAndPop());
      else if (!s.equals(" "))
        stack.push(Integer.parseInt(s));
    }
    System.out.println(stack.topAndPop());
  }
}