package exercicios.datastructures.josepheus.joseheus;

import exercicios.datastructures.josepheus.arrayqueue.ArrayQueue;

/**
 * ***********************************************************************
 * Compilation: javac Josephus.java Execution: java Josephus M N Dependencies:
 * Queue.java
 *
 * Solves the Josephus problem.
 *
 * % java Josephus 5 9 5 1 7 4 3 6 9 2 8
 *
 ************************************************************************
 */
public class Josepheus {

  public static void main(String[] args) {
    int M = Integer.parseInt(args[0]);
    int N = Integer.parseInt(args[1]);

    // initialize the queue
    ArrayQueue q = new ArrayQueue();
    for (int i = 1; i <= N; i++)
      q.enqueue(i);

    while (!q.isEmpty()) {
      for (int i = 0; i < M - 1; i++)
        q.enqueue(q.dequeue());
      System.out.print(q.dequeue() + " ");
    }
    System.out.println();
  }
}