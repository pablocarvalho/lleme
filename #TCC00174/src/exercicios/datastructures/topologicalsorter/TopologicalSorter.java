package exercicios.datastructures.topologicalsorter;

import exercicios.datastructures.topologicalsorter.arrayqueue.ArrayQueue;
import java.util.Scanner;

/**
 * ***********************************************************************
 * Compilation: javac TopologicalSorter.java Execution: java TopologicalSorter N
 * < data.txt Dependencies: Queue.java
 *
 * Reads in a list of order pairs of integers between 0 and N-1. The pair (i, j)
 * indicates that i must be scheduled before j. If there is a total ordering of
 * the integers 0..N-1 that respects the partial order, then print it out.
 *
 * The program uses the following algorithm. For each node i, maintain a queue
 * out[i] of nodes that must be scheduled after i. Also maintain for each node i
 * the number of nodes indegree[i] that must be scheduled before i. Keep a queue
 * that contains all of the nodes with zero indegree. Repeatedly remove a node
 * with zero indegree, print it out, and decrease by 1 the indegree of all the
 * nodes in out[i].
 *
 * % java TopologicalSorter 8 < topological1.txt Scheduled: 0 3 5 7 4 2 1 6
 * Could not schedule:
 *
 * % java TopologicalSorter 8 < topological2.txt Scheduled: 0 3 5 4 Could not
 * schedule: 1 2 6 7
 *
 ************************************************************************
 */
public class TopologicalSorter {

  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);

    int[] indegree = new int[N];

    // can't create an array of integer queues
    ArrayQueue[] out = new ArrayQueue[N];

    for (int i = 0; i < N; i++)
      out[i] = new ArrayQueue();

    Scanner scan = new Scanner(args[1]);

    // read in the pairs
    while (scan.hasNext()) {
      int i = Integer.parseInt(scan.next());
      int j = Integer.parseInt(scan.next());
      out[i].enqueue(j);
      indegree[j]++;
    }

    // initialize the queue of nodes with 0 indegree
    ArrayQueue q = new ArrayQueue();
    for (int i = 0; i < N; i++)
      if (indegree[i] == 0)
        q.enqueue(i);

    // repeatedly find a node with 0 indegree
    System.out.print("Scheduled:          ");
    while (!q.isEmpty()) {
      int i = (Integer) q.dequeue();
      System.out.print(i + " ");
      while (!out[i].isEmpty()) {
        int j = (Integer) out[i].dequeue();
        indegree[j]--;
        if (indegree[j] == 0)
          q.enqueue(j);
      }
    }
    System.out.println();

    // check if any nodes not scheduled
    System.out.print("Could not schedule: ");
    for (int i = 0; i < N; i++)
      if (indegree[i] > 0)
        System.out.print(i + " ");
    System.out.println();
  }
}