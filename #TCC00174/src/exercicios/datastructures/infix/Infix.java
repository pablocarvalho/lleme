package exercicios.datastructures.infix;

import exercicios.datastructures.infix.arraystack.ArrayStack;
import java.util.Scanner;

/**
 * ***********************************************************************
 * Compilation: javac Evaluate.java Execution: java Evaluate Dependencies:
 * Stack.java
 *
 * Evaluates (fully parenthesized) arithmetic expressions using Dijkstra"s
 * two-stack algorithm.
 *
 * % java Evaluate ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) 101.0
 *
 * % java Evaulate ( ( 1 + sqrt ( 5 ) ) / 2.0 ) 1.618033988749895
 *
 *
 *
 * Remarkably, Dijkstra"s algorithm computes the same answer if we put each
 * operator *after* its two operands instead of *between* them.
 *
 * % java Evaluate ( 1 ( ( 2 3 + ) ( 4 5 * ) * ) + ) 101.0
 *
 * Moreover, in such expressions, all parentheses are redundant! Removing them
 * yields an expression known as a postfix expression. 1 2 3 + 4 5 * * +
 *
 *
 ************************************************************************
 */
public class Infix {

  public static void main(String[] args) {
    ArrayStack ops = new ArrayStack();
    ArrayStack vals = new ArrayStack();

    Scanner scan = new Scanner(args[0]);

    while (scan.hasNext()) {
      String s = scan.next();
      if (s.equals("("))               ; else if (s.equals("+"))
        ops.push(s);
      else if (s.equals("-"))
        ops.push(s);
      else if (s.equals("*"))
        ops.push(s);
      else if (s.equals("/"))
        ops.push(s);
      else if (s.equals(")")) {
        Character op = (Character) ops.topAndPop();
        Double v = (Double) vals.topAndPop();
        if (op.equals("+"))
          v = (Double) vals.topAndPop() + v;
        else if (op.equals("-"))
          v = (Double) vals.topAndPop() - v;
        else if (op.equals("*"))
          v = (Double) vals.topAndPop() * v;
        else if (op.equals("/"))
          v = (Double) vals.topAndPop() / v;
        vals.push(v);
      } else if (!s.equals(" "))
        vals.push(Double.parseDouble(s.toString()));
    }
    System.out.println("vals: " + vals.topAndPop());
  }
}
