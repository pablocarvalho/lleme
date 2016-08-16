package exercicios.interface_.FormasGeometricas;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Insertion Sort
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class InsertionSort {

  /**
   * Insere o objeto na posicao correta.
   *
   * @param elem Elemento que esta sendo posicionado.
   * @param comparavel Colecao de objetos para serem comparados.
   * @param i Posicao atual.
   */
  public static void inserirNaPosicao(IComparavel elem, IComparavel[] comparavel, int i) {
    boolean achou = false;
    while ((i > 0) && (!achou))
      if (elem.compararCom(comparavel[i - 1]) < 0) {
        comparavel[i] = comparavel[i - 1];
        i--;
      } else
        achou = true;
    comparavel[i] = elem;
  }

  /**
   * Ordena um array de objetos.
   *
   * @param comparavel Objetos a serem ordenados.
   * @param numElem Numero de objetos a serem ordenados.
   */
  public static void ordenar(IComparavel[] comparavel, int numElem) {

    /*
     * Polimorfismo:
     * Nao importa para a classe SelectionSort o tipo dos
     * objetos que serao ordenados.
     */
    for (int i = 1; i < numElem; i++)
      inserirNaPosicao(comparavel[i], comparavel, i);
  }
}
