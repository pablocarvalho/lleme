/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.datastructures.linkedStack.linkedlist;

// Queue interface
//
// ******************PUBLIC OPERATIONS*********************
// void insertAtFront( x )   --> Insert x
// void insertAtBack( x )    --> Insert x
// Object removeFromFront( ) --> Return first inserted item
// Object removeFromBack( )  --> Return least recently inserted item
// boolean isEmpty( )        --> Return true if empty; else false
// void makeEmpty( )         --> Remove all items
// ******************ERRORS********************************
// removeFromFront or removeFromBack on empty lists
public interface List {

  /**
   * Insert a new item into the begin of the list.
   *
   * @param x the item to insert.
   */
  public void insertAtFront(Object insertItem);

  /**
   * Insert a new item into the end of the list.
   *
   * @param x the item to insert.
   */
  public void insertAtBack(Object insertItem);

  /**
   * Get the first inserted item in the list.
   *
   * @return the first inserted item in the list.
   * @exception UnderflowException if the list is empty.
   */
  public Object removeFromFront();

  /**
   * Get the last inserted item in the list.
   *
   * @return the least inserted item in the list.
   * @exception UnderflowException if the list is empty.
   */
  public Object removeFromBack();

  /**
   * Test if the list is logically empty.
   *
   * @return true if empty, false otherwise.
   */
  public boolean isEmpty();

  /**
   * Make the list logically empty.
   */
  public void makeEmpty();
}
