package exercicios.interface_.SelfAvoidingRandomWalk;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

  private MainCanvas mainCanvas;
  private StatusBar statusBar;

  public MainFrame() {

    mainCanvas = new MainCanvas();
    statusBar = new StatusBar();
    BorderLayout bord = new BorderLayout();
    setLayout(bord);
    add(mainCanvas, BorderLayout.CENTER);
    add(statusBar, BorderLayout.SOUTH);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("SelfAvoidingRandomWalk");
    setSize(400, 400);
    setVisible(true);
  }

  public StatusBar getStatusBar() {
    return statusBar;
  }

  public MainCanvas getMainCanvas() {
    return mainCanvas;
  }

  public void actionPerformed(ActionEvent event) {
  }
}