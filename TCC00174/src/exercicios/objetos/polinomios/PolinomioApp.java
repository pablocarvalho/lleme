package exercicios.objetos.polinomios;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Polinomios
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class PolinomioApp {

  /**
   * Testa a classe de Polinomios
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {
    int[] v = {1, 1, 2};
    Polinomio p = new Polinomio(v);
    p.print();
    int[] w = {1, 3, 4, 2, 5};
    Polinomio q = new Polinomio(w);
    q.print();
    Polinomio r = p.somar(q);
    r.print();
    Polinomio s = q.multiplicar(p);
    s.print();
  }
}
