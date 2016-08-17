package exercicios.introducao;

/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Metodo de Newton
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class MetodoDeNewton {

  /**
   * Calcula a raiz da equacao f(x)=0
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {
    // Recebe os argumentos da linha de comando
    double c = Double.parseDouble(args[0]);
    // Define precisao
    double epsilon = 1e-15;
    // Chute inicial
    double t = c;

    while (Math.abs(t * t - c) > epsilon)
      t = (c / t + t) / 2.0;

    System.out.println(t);
  }
}
