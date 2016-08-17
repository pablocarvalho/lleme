package exercicios.datastructures.linkedQueue.linkedlist;

public class LinkedListException extends RuntimeException {
  // no-argument constructor

  public LinkedListException() {
    this("List"); // call other LinkedListException constructor
  } // end LinkedListException no-argument constructor

  // one-argument constructor
  public LinkedListException(String name) {
    super(name + " is empty"); // call superclass constructor
  } // end LinkedListException one-argument constructor
} // end class LinkedListException