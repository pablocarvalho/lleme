/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00174.exercicios.datastructures.arrayqueue;

/**
 * Exception class for access in empty containers such as stacks, queues, and
 * priority queues.
 *
 * @author Mark Allen Weiss
 */
public class ArrayQueueException extends RuntimeException {

  /**
   * Construct this exception object.
   *
   * @param message the error message.
   */
  public ArrayQueueException(String message) {
    super(message);
  }
}
