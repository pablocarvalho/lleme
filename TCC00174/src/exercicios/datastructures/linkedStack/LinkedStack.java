package exercicios.datastructures.linkedStack;

import exercicios.datastructures.linkedStack.linkedlist.LinkedList;
import exercicios.datastructures.linkedStack.linkedlist.LinkedListException;

public class LinkedStack implements Stack {

  private LinkedList stackList;

  public LinkedStack() {
    stackList = new LinkedList();
  }

  @Override
  public void push(Object object) {
    stackList.insertAtBack(object);
  }

  @Override
  public Object pop() throws LinkedListException {
    return stackList.removeFromBack();
  }

  @Override
  public boolean isEmpty() {
    return stackList.isEmpty();
  }

  public void print() {
    stackList.print();
  }

  @Override
  public void makeEmpty() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Object top() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
