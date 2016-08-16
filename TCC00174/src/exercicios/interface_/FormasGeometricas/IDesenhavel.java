package exercicios.interface_.FormasGeometricas;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Interface Desenhavel
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.awt.Graphics2D;

public interface IDesenhavel {

  /**
   * Metodo que desenha objetos.
   *
   * @param comp2D Contexto gráfico.
   */
  void desenhar(Graphics2D comp2D);
}
