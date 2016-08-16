package exercicios.interface_.FormasGeometricas;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Insertion Sort
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import javax.swing.JFrame;

public class MainFrame extends JFrame {

  MainFrame(ColecaoFormas cf) {

    MainCanvas mainCanvas = new MainCanvas(cf);
    add(mainCanvas);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("MiniDraw");
    setSize(512, 512);
    setVisible(true);
  }
}
