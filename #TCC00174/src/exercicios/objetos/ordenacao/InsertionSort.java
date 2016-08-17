package exercicios.objetos.ordenacao;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Insertion Sort
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class InsertionSort {

  /**
   * Ordena um array de objetos.
   *
   * @param comparavel Objetos a serem ordenados.
   * @param numElem Numero de objetos a serem ordenados.
   */
  public static void ordenar(IComparavel[] comparavel, int size) {

    /*
     * Polimorfismo:
     * Nao importa para a classe SelectionSort o tipo dos
     * objetos que serao ordenados.
     */
    for (int i = 1; i < size; i++) {
      int j = i;

      while ((j > 0) && (comparavel[j].compararCom(comparavel[j - 1]) < 0)) {
        IComparavel tmp = comparavel[ j];
        comparavel[ j] = comparavel[j - 1];
        comparavel[j - 1] = tmp;
        j--;
      }
    }
  }
}
