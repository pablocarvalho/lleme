package exercicios.objetos.ordenacao;

/**
 * Programacao de computadores II TCC-00174 Aula 2 - Orientacao a objetos,
 * Exercícios. Classe Automoveis
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.util.Scanner;

public class Automoveis {

  final int maxAutomoveis = 100; //> Numero maximo de automoveis
  private int numAutomoveis;       //> Numero atual de automoveis
  private Automovel[] colecao;     //> Array de automoveis

  /**
   * Construtor default.
   */
  Automoveis() {
    numAutomoveis = 0;
    colecao = new Automovel[maxAutomoveis];
  }

  /**
   * Acesso ao array de automoveis.
   *
   * @return colecao de automoveis.
   */
  public Automovel[] getColecao() {
    return colecao;
  }

  /**
   * Acesso ao numero de automoveis na colecao.
   *
   * @return numero de automoveis.
   */
  public int getNumAutomoveis() {
    return numAutomoveis;
  }

  /**
   * Insere um automovel na colecao.
   *
   * @param auto Automovel a ser inserido na colecao
   */
  public void inserir(Automovel auto) {
    try {
      colecao[numAutomoveis] = auto;
      numAutomoveis++;
    } catch (ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    }
  }

  /**
   * Leitura de uma colecao de automoveis pelo teclado.
   *
   * @return Colecao de automoveis
   */
  public static Automoveis lerTeclado() {

    // Numero de automoveis que serao criados
    System.out.println("Digite o numero de automoveis");
    Scanner scanner = new Scanner(System.in);
    int numAutomoveis = scanner.nextInt();

    // Criacao da colecao de automoveis
    Automoveis automoveis = new Automoveis();
    System.out.println("Digite os dados dos automoveis");

    // Leitura de cada automovel
    for (int i = 0; i < numAutomoveis; i++) {
      // Leitura da marca
      String marca = scanner.next();

      // Leitura do automovel
      float velocidadeMaxima = scanner.nextFloat();

      // Criacao e inclusao do automovel na colecao
      Automovel auto = new Automovel(marca, velocidadeMaxima);
      automoveis.inserir(auto);
    }

    return automoveis;
  }

  /**
   * Imprime a colecao de carros.
   */
  public void imprimir() {
    for (int i = 0; i < numAutomoveis; i++)
      colecao[i].imprimir();
  }
}
