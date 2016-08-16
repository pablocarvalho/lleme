package exercicios.datastructures.linkedStack.linkedlist;

// class to represent one node in a list
class ListNode {
  // package access members; List can access these directly

  Object data; // data for this node
  ListNode nextNode; // reference to the next node in the list

  // constructor creates a ListNode that refers to object
  ListNode(Object object) {
    this(object, null);
  } // end ListNode one-argument constructor 

  // constructor creates ListNode that refers to 
  // Object and to next ListNode
  ListNode(Object object, ListNode node) {
    data = object;
    nextNode = node;
  } // end ListNode two-argument constructor

  // return reference to data in node
  Object getObject() {
    return data; // return Object in this node
  } // end method getObject

  // return reference to next node in list
  ListNode getNext() {
    return nextNode; // get next node
  } // end method getNext
} // end class ListNode
