package exercicios.backtracking.curvadehilbert;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Canvas extends JPanel {

  CurvaDeHilbert curva = null;

  Canvas() {
    setSize(512, 512);
  }

  ;

    public void setCurva(CurvaDeHilbert curva) {
    this.curva = curva;
  }

  public void paintComponent(Graphics comp) {

    super.paintComponent(comp);
    Graphics2D comp2D = (Graphics2D) comp;

    if (curva != null)
      curva.draw(comp2D);
  }
}
