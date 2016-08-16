package exercicios.datastructures.arraylist;

public class ArrayList implements List {

  protected Object[] arr;
  protected int start, end;
  private static final int DEFAULT_CAPACITY = 10;

  public ArrayList() {
    arr = new Object[DEFAULT_CAPACITY];
    start = end = DEFAULT_CAPACITY / 2;
  }

  @Override
  public void insertAtFront(Object o) {
    resize(start - 1);
    start = (start - 1);
    arr[start] = o;
  }

  @Override
  public void insertAtBack(Object o) {
    resize(end + 1);
    arr[end] = o;
    end = (end + 1);
  }

  @Override
  public Object removeFromFront() {
    if (isEmpty())
      return null;
    Object o = arr[start];
    arr[start] = null;
    start = (start + 1);
    return o;
  }

  @Override
  public Object removeFromBack() {
    if (isEmpty())
      return null;
    end = (end - 1);
    Object o = arr[end];
    arr[end] = null;
    return o;
  }

  @Override
  public boolean isEmpty() {
    return start == end;
  }

  @Override
  public void makeEmpty() {
    start = end = arr.length / 2;
    for (int i = 0; i < arr.length; i++)
      arr[i] = null;
  }

  //--------- Fora da interface.
  public int size() {
    return (end - start);
  }

  private void resize(int pos) {

    if (pos < 0 || pos >= arr.length) {
      int oldlen = end - start;    //> old list size
      int oldsize = arr.length;  //> old array size

      // New array
      Object[] narr = new Object[2 * oldsize];

      // Copy the old vector starting from oldsize/2
      System.arraycopy(arr, start, narr, oldsize / 2, oldlen);

      // New start and end
      start = oldsize / 2;
      end = start + oldlen;
      arr = narr;
    }
  }

  public Object get(int n) {
    int siz = size();
    if (n >= siz)
      return null;
    if (n >= 0)
      return arr[(start + n)];
    return null;
  }

  public void set(int n, Object o) {
    if (n >= start && n < end) {
      int idx = (start + n);
      arr[idx] = o;
    }
  }

  public void print() {

    for (int i = start; i < end; i++)
      System.out.print(arr[i] + " ");
    System.out.println("\n");
  }
}
