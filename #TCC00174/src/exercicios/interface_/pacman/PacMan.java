package exercicios.interface_.pacman;

import javax.swing.JFrame;

import exercicios.interface_.pacman.Board;

public class PacMan extends JFrame {

  public PacMan() {
    add(new Board());
    setTitle("Pacman");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(380, 420);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args) {
    new PacMan();
  }
}
