package exercicios.backtracking.puzzle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ananmon
 */
public class Puzzle {

  public static void main(String[] args) {
    Board board = new Board();
    board.print();
    System.out.println("_________");
    board.play();
  }
}
