package exercicios.backtracking;

public class Maze {

  private int[][] maze;             /* Our maze is maintained in an array of integers */

  private final char wall = '_';    /* non-navigable walls in the maze */

  private final char finish = 'F';  /* the finish point in the maze */

  private final char start = 'S';   /* the starting point in the maze */

  private final int blocked = -1;   /* cannot move through wall position and show it as blocked */

  private final int visited = -2;  /* we mark paths that are unsuccessful as "visited" to prevent trying to navigate them again. */

  private final int end = -3;      /* we need to mark the end with an integer to identify it. We use -3 */

  private int startRow;            /* Keep track of where to start - the row */

  private int startCol;            /* and the col */

  private static final int[] moveX = {0, 1, 0, -1};
  private static final int[] moveY = {-1, 0, 1, 0};
  private static final char[] dir = {'^', '>', 'v', '<'};

  public Maze(String[] m) {
    if (m.length > 0) {
      maze = new int[m.length][m[0].length()];
      for (int i = 0; i < m.length; i++)
        for (int j = 0; j < m[i].length(); j++) {
          if (m[i].charAt(j) == wall)
            maze[i][j] = blocked;
          if (m[i].charAt(j) == finish)
            maze[i][j] = end;
          if (m[i].charAt(j) == start) {
            startRow = i;
            startCol = j;
          }
        }
    } else
      throw new RuntimeException("Invalid Maze!");
  }

  public void printMaze() {
    for (int i = 0; i < maze.length; i++) {
      for (int j = 0; j < maze[i].length; j++) {
        if (maze[i][j] == -1)
          System.out.print('_');
        if (maze[i][j] == -2)
          System.out.print('.');
        if (maze[i][j] == -3)
          System.out.print('F');
        if (maze[i][j] == 0)
          System.out.print(' ');
        if (maze[i][j] > 0)
          System.out.print((char) maze[i][j]);
      }
      System.out.print("\n");
    }
  }

  public boolean canFinish() {
    return walkMaze(startRow, startCol, 'S');
  }

  public boolean walkMaze(int row, int col, char direction) {

    if (row < 0 || row >= maze.length
            || col < 0 || col >= maze[0].length
            || (maze[row][col] != 0 && maze[row][col] != end))
      return false;

    if (maze[row][col] == end)
      return true;

    maze[row][col] = direction;

    int move = 0; // start at the beginning of the dir_ dirY arrays
    boolean found = false; // initialized to not found 
    while (!found && move < moveX.length) {
      found = walkMaze(row + moveY[move], col + moveX[move], dir[move]);
      move++;
    }

    if (!found)
      maze[row][col] = visited;
    return found;
  }

  public static void main(String[] args) {
    String[] myMaze = {
      "__S_____________________________",
      "__ _____________     ___________",
      "__    __________ ___ __     ____",
      "_____  ______    ___ __ ___ ____",
      "___ __ ______ __ ___ __  __ ____",
      "___     _____ ______ ______ ____",
      "_______       ______        ____",
      "__________ _____ _______________",
      "__________ __    _____      ____",
      "__________    ________ ____ ____",
      "___________ __________ ____ ____",
      "___________            ____ ____",
      "________________________ __ ____",
      "______              ____ __ ____",
      "______ ____________ __      ____",
      "______ __    ______ ____ _______",
      "______ _____   ___            __",
      "______ _______ ___________ _____",
      "______ _______ _________________",
      "______F_________________________"};

    Maze m = new Maze(myMaze);
    if (m.maze[0][0] != 0)
      System.out.println("this is not zero");
    if (m.canFinish())  // call method to start maze walk.
      m.printMaze();
    else {
      m.printMaze();
      System.out.println("No way to get there!");
    }

  }
}
