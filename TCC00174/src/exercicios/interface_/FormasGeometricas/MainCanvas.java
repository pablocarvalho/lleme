package exercicios.interface_.FormasGeometricas;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Insertion Sort
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MainCanvas extends JPanel {

  ColecaoFormas cf;

  public MainCanvas(ColecaoFormas cf) {
    this.cf = cf;
  }

  @Override
  public void paintComponent(Graphics comp) {
    super.paintComponent(comp);
    Graphics2D comp2D = (Graphics2D) comp;
    cf.desenhar(comp2D);
  }
}
