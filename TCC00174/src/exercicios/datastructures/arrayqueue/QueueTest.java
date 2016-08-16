package exercicios.datastructures.arrayqueue;

public class QueueTest {

  public static void main(String args[]) {
    ArrayQueue list = new ArrayQueue();

    list.enqueue(-1);
    list.print();
    list.enqueue(0);
    list.print();
    list.enqueue(1);
    list.print();
    list.enqueue(5);
    list.print();

    try {
      Object removedObject = list.dequeue();
      System.out.printf("%s removed\n", removedObject);
      list.print();

      removedObject = list.dequeue();
      System.out.printf("%s removed\n", removedObject);
      list.print();

      removedObject = list.dequeue();
      System.out.printf("%s removed\n", removedObject);
      list.print();

      removedObject = list.dequeue();
      System.out.printf("%s removed\n", removedObject);
      list.print();
    } catch (Exception emptyListException) {
      emptyListException.printStackTrace();
    }
  }
}
