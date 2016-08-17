/**
 * Programacao de computadores II TCC-00174 Aula 3 - Entrada e Saída com
 * Arquivos, Exercícios. Classe Leitor de imagem
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.arquivos.leImagem;

import java.awt.Image;
import java.awt.BorderLayout;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.BufferedInputStream;

import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Main {

  /**
   * Programa que ilustra como usar a classe ImageIO para ler imagens em
   * formatos proprietários (*.jpg,*.bmp,*.gif,etc.)
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {
    Image image = null;

    try {
      FileInputStream file = new FileInputStream("./src/leimagem/cobao.jpg");
      BufferedInputStream bis = new BufferedInputStream(file);

      image = ImageIO.read(bis);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    JFrame frame = new JFrame();
    JLabel label = new JLabel(new ImageIcon(image));

    frame.getContentPane().add(label, BorderLayout.CENTER);

    frame.pack();
    frame.setVisible(true);

  }
}
