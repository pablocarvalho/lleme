package exercicios.backtracking.puzzle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ananmon
 */
public class Board {

  private static final int BOARD_SIZE = 5;
  private Ball[] cells;
  private static final int NUM_MOVEMENTS = 8;
  private int[] movements = {1, 2, 1, 2, -1, -2, -1, -2};

  Board() {
    cells = new Ball[BOARD_SIZE];

    for (int i = 0; i < BOARD_SIZE; i++)
      cells[i] = null;

    for (int i = 0; i < BOARD_SIZE / 2; i++)
      cells[i] = new Ball(i, 'B', i);

    for (int i = BOARD_SIZE / 2 + 1; i < BOARD_SIZE; i++)
      cells[i] = new Ball(i - 1, 'R', i);

  }

  public boolean isEmpty(int i) {
    return (cells[i] == null);
  }

  public void print() {
    for (int i = 0; i < BOARD_SIZE; i++)
      if (cells[i] != null)
        System.out.print(cells[i]);
      else
        System.out.print(" ");

    System.out.println();
  }

  public boolean canMoveBall(int pos, int move) {
    // if there is no ball return false
    if (cells[pos] == null)
      return false;

    // get the displacement of the ball
    int k = movements[2 * cells[pos].getId() + move];

    // if the movement is out of bounds return false
    if ((pos + k) < 0 || (pos + k) >= BOARD_SIZE)
      return false;

    // if the final position is not empty
    if (cells[pos + k] != null)
      return false;

    if (move == 0)
      return true;
    else if (move == 1)
      if (cells[pos + k / 2].getColor() != cells[pos].getColor())
        return true;

    return false;
  }

  public void moveBall(int pos, int move) {
    // get the displacement of the ball
    int k = movements[2 * cells[pos].getId() + move];

    // move the ball
    cells[pos + k] = cells[pos];
    // update ball position
    cells[pos].setPosition(pos + k);
    // dispose the cell
    cells[pos] = null;

  }

  public void undoMoveBall(int pos, int move) {
    // get the displacement of the ball
    int k = movements[2 * cells[pos].getId() + move];

    // move the ball
    cells[pos - k] = cells[pos];
    // update ball position
    cells[pos].setPosition(pos - k);
    // dispose the cell
    cells[pos] = null;
  }

  public boolean won() {
    for (int i = 0; i < BOARD_SIZE / 2; i++)
      if ((cells[i] == null) || (cells[i].getColor() != 'R'))
        return false;

    for (int i = BOARD_SIZE / 2 + 1; i < BOARD_SIZE; i++)
      if ((cells[i] == null) || (cells[i].getColor() != 'B'))
        return false;

    return true;
  }

  public boolean play() {
    Ball movedBall = null;
    int oldMovement;
    boolean success = false;
    boolean movedOnce = false;

    for (int pos = 0; pos < BOARD_SIZE && !success; pos++)
      for (int move = 0; move <= 1; move++)
        if (canMoveBall(pos, move)) {
          movedOnce = true;
          movedBall = cells[pos];
          oldMovement = move;
          moveBall(pos, move);
          print();

          if (won()) {
            System.out.println("WON...");
            return true;
          } else {
            success = play();
            if (!success) {
              undoMoveBall(movedBall.getPosition(), oldMovement);
              print();
            }
          }
        }

    if (!movedOnce) {
      System.out.println("BLOCKED...");
      System.out.println("__________");
    }


    return success;
  }
}
