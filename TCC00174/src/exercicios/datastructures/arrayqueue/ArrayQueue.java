package exercicios.datastructures.arrayqueue;

public class ArrayQueue implements Queue {

  private Object[] theArray;
  private int front;
  private int back;
  private static final int DEFAULT_CAPACITY = 10;

  public ArrayQueue() {
    theArray = new Object[DEFAULT_CAPACITY];
    makeEmpty();
  }

  @Override
  public boolean isEmpty() {
    return front == back;
  }

  @Override
  public void makeEmpty() {
    front = back = 0;
  }

  @Override
  public Object dequeue() {

    if (isEmpty())
      throw new ArrayQueueException("ArrayQueue dequeue");

    Object returnValue = theArray[ front];
    front = front + 1;
    return returnValue;
  }

  @Override
  public Object getFront() {
    if (isEmpty())
      throw new ArrayQueueException("ArrayQueue getFront");
    return theArray[ front];
  }

  @Override
  public void enqueue(Object x) {
    if (back >= theArray.length)
      doubleQueue();
    theArray[ back] = x;
    back = back + 1;
  }

  //------
  private int increment(int x) {
    if (++x == theArray.length)
      x = 0;
    return x;
  }

  private void doubleQueue() {
    Object[] newArray;

    newArray = new Object[theArray.length * 2];

    for (int i = 0; i < back - front; i++, front = increment(front))
      newArray[ i] = theArray[ front];

    int oldsize = back - front;

    theArray = newArray;
    front = 0;
    back = oldsize;
  }

  public void print() {

    for (int i = front; i < back; i++)
      System.out.print(theArray[i] + " ");
    System.out.println("\n");
  }
}