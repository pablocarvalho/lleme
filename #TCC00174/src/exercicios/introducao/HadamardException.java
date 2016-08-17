package exercicios.introducao;

/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Matriz de Hadamard
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class HadamardException extends Exception {

  public String getMessage() {
    return "Impossivel criar a Matriz de Hadamard. Ordem da matriz deve ser potencia de 2.";
  }
}
