package exercicios.objetos.ordenacao;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Bubble Sort
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class BubbleSort {

  /**
   * Ordena um array de objetos.
   *
   * @param comparavel Objetos a serem ordenados.
   */
  public static void ordenar(IComparavel[] comparavel, int size) {

    /*
     * Polimorfismo:
     * Nao importa para a classe SelectionSort o tipo dos
     * objetos que serao ordenados.
     */
    for (int i = 1; i < size; i++)
      for (int j = size - 1; j >= i; j--)
        if (comparavel[j - 1].compararCom(comparavel[j]) > 0) {
          IComparavel elem = comparavel[j - 1];
          comparavel[j - 1] = comparavel[j];
          comparavel[ j] = elem;
        }
  }
}
