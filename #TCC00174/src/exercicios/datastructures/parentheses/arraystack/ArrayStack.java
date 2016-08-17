package exercicios.datastructures.parentheses.arraystack;

// ArrayStack class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void push( x )         --> Insert x
// void pop( )            --> Remove most recently inserted item
// Object top( )          --> Return most recently inserted item
// Object topAndPop( )    --> Return and remove most recent item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// top, pop, or topAndPop on empty stack
public class ArrayStack implements Stack {

  private Object[] theArray;
  private int topOfStack;
  private static final int DEFAULT_CAPACITY = 10;

  public ArrayStack() {
    theArray = new Object[DEFAULT_CAPACITY];
    topOfStack = 0;
  }

  public boolean isEmpty() {
    return topOfStack == 0;
  }

  public void makeEmpty() {
    topOfStack = 0;
  }

  public Object top() {
    if (isEmpty())
      throw new ArrayStackException("ArrayStack top");
    return theArray[ topOfStack];
  }

  public Object pop() {
    if (isEmpty())
      throw new ArrayStackException("ArrayStack topAndPop");
    return theArray[--topOfStack];
  }

  public void push(Object x) {
    if (topOfStack == theArray.length)
      resize();
    theArray[topOfStack++] = x;
  }

  private void resize() {
    Object[] newArray;

    newArray = new Object[theArray.length * 2];
    for (int i = 0; i < theArray.length; i++)
      newArray[ i] = theArray[ i];
    theArray = newArray;
  }

  public void print() {

    for (int i = 0; i < topOfStack; i++)
      System.out.print(theArray[i] + " ");
    System.out.println("\n");
  }
}