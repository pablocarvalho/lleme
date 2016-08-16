package exercicios.objetos.ordenacao;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Selection Sort
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class SelectionSort {

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
    for (int i = 0; i < size; i++) {

      int pos = i;
      for (int j = i + 1; j < size; j++)
        if (comparavel[j].compararCom(comparavel[pos]) < 0)
          pos = j;

      IComparavel elem = comparavel[i];
      comparavel[i] = comparavel[pos];
      comparavel[pos] = elem;
    }
  }
}
