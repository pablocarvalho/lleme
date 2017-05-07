package uff.ic.tcc00174.exercicios.interface_.SelfAvoidingRandomWalk;

import java.awt.Dimension;
import javax.swing.JLabel;

public class StatusBar extends JLabel {

  public StatusBar() {
    super();
    setMessage("Ready");
  }

  public void setMessage(String message) {
    setText(" " + message);
  }
}
