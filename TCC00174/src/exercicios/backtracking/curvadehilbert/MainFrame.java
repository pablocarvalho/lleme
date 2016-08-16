package exercicios.backtracking.curvadehilbert;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

  private Canvas canvas;

  public Canvas getCanvas() {
    return canvas;
  }

  MainFrame() {
    super("Curva de Hilbert");
    canvas = new Canvas();
    add(canvas);
    setSize(512, 534);
    this.setVisible(true);
  }
}
