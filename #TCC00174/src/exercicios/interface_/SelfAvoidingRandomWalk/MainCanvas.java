package exercicios.interface_.SelfAvoidingRandomWalk;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MainCanvas extends JPanel {

  static final int MAXDRAWABLES = 10;
  Drawable[] drawableObjects;
  int numDrawables = 0;

  public MainCanvas() {
    numDrawables = 0;
    drawableObjects = new Drawable[MAXDRAWABLES];
  }

  @Override
  public void paintComponent(Graphics comp) {
    super.paintComponent(comp);
    Graphics2D comp2D = (Graphics2D) comp;

    for (int i = 0; i < numDrawables; i++)
      drawableObjects[i].draw(comp2D);

  }

  public void addDrawbleObjects(Drawable drawableObject) {
    drawableObjects[numDrawables++] = drawableObject;
  }
}
