package exercicios.introducao;

/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Fatores Primos
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
public class FatoresPrimos {

  /**
   * Versão simples para o calculo dos fatores primos.
   *
   * @param number numero que desejamos fatorar.
   */
  public static void simples(int number) {
    int n = number, m = number;

    System.out.println("Versao simples:");
    for (int i = 2; i <= m; i++)
      while (n % i == 0) {
        System.out.println(i);
        n /= i;
      }
  }

  /**
   * Versão eficiente para o calculo dos fatores primos.
   *
   * @param number numero que desejamos fatorar.
   */
  public static void eficiente(int number) {
    int n = number;

    System.out.println("Versao eficiente:");

    for (int i = 2; i <= n; i++)
      while (n % i == 0) {
        System.out.println(i);
        n /= i;
      }
  }

  /**
   * Versão eficiente para o calculo dos fatores primos.
   *
   * @param number numero que desejamos fatorar.
   */
  public static void fatores(int number) {
    int n = number;
    int last = 1;

    System.out.println("Versao fatores:");
    for (int i = 2; i <= n; i++)
      while (n % i == 0) {
        if (i != last)
          System.out.println(i);
        n /= i;
        last = i;
      }
  }

  /**
   * Calcula os fatores primos de um numero inteiro.
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {
    try {
      // Recebe os argumentos da linha de comando
      int number = Integer.parseInt(args[0]);

      // Executa os metodos
      simples(number);
      eficiente(number);
      fatores(number);

    } // Erro no numero de argumentos        
    catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e.toString());
    }
  }
}
