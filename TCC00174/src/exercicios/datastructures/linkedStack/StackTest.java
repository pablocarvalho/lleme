package exercicios.datastructures.linkedStack;

import exercicios.datastructures.linkedStack.LinkedStack;

public class StackTest {

  public static void main(String args[]) {
    LinkedStack stack = new LinkedStack();

    stack.push(-1);
    stack.print();
    stack.push(0);
    stack.print();
    stack.push(1);
    stack.print();
    stack.push(5);
    stack.print();

    try {
      Object removedObject = stack.pop();
      System.out.printf("%s removed\n", removedObject);
      stack.print();

      removedObject = stack.pop();
      System.out.printf("%s removed\n", removedObject);
      stack.print();

      removedObject = stack.pop();
      System.out.printf("%s removed\n", removedObject);
      stack.print();

      removedObject = stack.pop();
      System.out.printf("%s removed\n", removedObject);
      stack.print();
    } catch (Exception emptyListException) {
      emptyListException.printStackTrace();
    }
  }
}
