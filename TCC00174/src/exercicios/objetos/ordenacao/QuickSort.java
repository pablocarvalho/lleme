package exercicios.objetos.ordenacao;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Quick Sort
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class QuickSort {

  private static int particionar(IComparavel[] c, int esq, int dir) {
    IComparavel x = c[esq];
    int i = esq - 1;
    int j = dir + 1;
    while (true) {
      do
        j--;
      while (x.compararCom(c[j]) == -1);
      do
        i++;
      while (x.compararCom(c[i]) == 1);
      if (i < j) {
        IComparavel temp;
        temp = c[i];
        c[i] = c[j];
        c[j] = temp;
      } else
        return j;
    }
  }

  private static void recOrdenar(IComparavel[] comparaveis, int esq, int dir) {
    if (esq < dir) {
      int pivo = particionar(comparaveis, esq, dir);
      System.out.println(pivo);
      recOrdenar(comparaveis, esq, pivo - 1);
      recOrdenar(comparaveis, pivo + 1, dir);
    }
  }

  /**
   * Ordena um array de objetos.
   *
   * @param comparavel Objetos a serem ordenados.
   */
  public static void ordenar(IComparavel[] comparaveis) {
    recOrdenar(comparaveis, 0, comparaveis.length - 1);
  }
}
