package exercicios.backtracking.puzzle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ananmon
 */
public class Ball {

  private int id;
  private char color;
  private int position;

  Ball(int id, char color, int pos) {
    this.id = id;
    this.color = color;
    position = pos;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public char getColor() {
    return color;
  }

  public void setColor(char color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "" + color + id;
  }
}
