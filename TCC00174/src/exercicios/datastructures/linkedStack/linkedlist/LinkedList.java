package exercicios.datastructures.linkedStack.linkedlist;

public class LinkedList implements List {

  private ListNode firstNode;
  private ListNode lastNode;

  public LinkedList() {
    firstNode = lastNode = null;
  }

  @Override
  public void insertAtFront(Object insertItem) {
    if (isEmpty())
      firstNode = lastNode = new ListNode(insertItem);
    else
      firstNode = new ListNode(insertItem, firstNode);
  }

  @Override
  public void insertAtBack(Object insertItem) {
    if (isEmpty())
      firstNode = lastNode = new ListNode(insertItem);
    else
      lastNode = lastNode.nextNode = new ListNode(insertItem);
  }

  @Override
  public Object removeFromFront() throws LinkedListException {
    if (isEmpty())
      throw new LinkedListException("LinkedList.removeFromFront error");

    Object removedItem = firstNode.data;

    if (firstNode == lastNode)
      firstNode = lastNode = null;
    else
      firstNode = firstNode.nextNode;

    return removedItem;
  }

  @Override
  public Object removeFromBack() throws LinkedListException {
    if (isEmpty())
      throw new LinkedListException("LinkedList.removeFromBack error");

    Object removedItem = lastNode.data;

    if (firstNode == lastNode)
      firstNode = lastNode = null;
    else {
      ListNode current = firstNode;

      while (current.nextNode != lastNode)
        current = current.nextNode;

      lastNode = current;
      current.nextNode = null;
    }

    return removedItem;
  }

  @Override
  public boolean isEmpty() {
    return firstNode == null;
  }

  public Object getFront() {
    if (isEmpty())
      return null;
    else
      return firstNode.data;
  }

  public Object getBack() {
    if (isEmpty())
      return null;
    else
      return firstNode.data;
  }

  @Override
  public void makeEmpty() {
    firstNode = lastNode = null;
  }

  public void print() {
    if (isEmpty())
      return;

    ListNode current = firstNode;

    while (current != null) {
      System.out.printf("%s ", current.data);
      current = current.nextNode;
    }

    System.out.println("\n");
  }
}
