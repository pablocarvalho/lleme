package provas.s20111;

public class P120111Ex2 {

  public static void main(String[] args) {
    boolean r = true;
    int i = 0, j = 0, m[][] = {{3, 2, 1}, {1, 1, 0},
      {0, 0, 7}, {0, 0, 2}};
    System.out.println("1\t" + i + "\t" + j + "\t" + r);
    while (i < 3) {
      System.out.println("2\t" + i + "\t" + j + "\t" + r);
      while (j < 3) {
        System.out.println("3\t" + i + "\t" + j + "\t" + r);
        if (i != j && i != j + 1 && i != j - 1 && m[i][j] != 0) {
          System.out.println("4\t" + i + "\t" + j + "\t" + r);
          r = false;
          System.out.println("5\t" + i + "\t" + j + "\t" + r);
        } else
          System.out.println("4\t" + i + "\t" + j + "\t" + r);
        j++;
        System.out.println("6\t" + i + "\t" + j + "\t" + r);
      }
      System.out.println("3\t" + i + "\t" + j + "\t" + r);
      i++;
      System.out.println("7\t" + i + "\t" + j + "\t" + r);
    }
    //System.out.println(r);
    System.out.println("2\t" + i + "\t" + j + "\t" + r);
  }
}
