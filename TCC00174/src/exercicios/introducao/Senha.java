/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Jogo das Senhas
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
package exercicios.introducao;

import java.util.Random;
import java.util.Scanner;

public class Senha {

  /**
   * Executa o jogo das senhas.
   *
   * @param args Argumentos de linha de comando.
   */
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite o tamanho senha");

    int tamSenha = scanner.nextInt();
    int[] senha = gerarSenha(tamSenha);

    boolean acertou = jogar(senha, tamSenha);

    imprimirResultado(acertou, senha);
  }

  /**
   * Gera as senhas.
   *
   * @param tamSenha Tamanho da senha.
   */
  private static int[] gerarSenha(int tamSenha) {

    int[] senha = new int[tamSenha];

    Random geradorAleatorio = new Random();

    for (int i = 0; i < tamSenha; i++)
      senha[i] = geradorAleatorio.nextInt(tamSenha);

    return senha;
  }

  /**
   * Jogada atual.
   *
   * @param senha Senha do jogador.
   * @param tamSenha Tamanho da senha.
   * @return O resultado do jogo
   */
  private static boolean jogar(int[] senha, int tamSenha) {

    Scanner scanner = new Scanner(System.in);

    int numTentativas = tamSenha;
    int tentativas = 0;
    int tentativa[] = new int[tamSenha];

    boolean descobriu = false;

    System.out.println("A senha contem digitos entre 0 e " + (tamSenha - 1));

    // Loop principal
    while ((tentativas < numTentativas) && (!descobriu)) {

      // Mensagem para o jogador
      if (tamSenha - tentativas > 1)
        System.out.println("Digite a senha. Restam " + (tamSenha - tentativas) + " tentativas!");
      else
        System.out.println("Digite a senha. Esta e a ultima tentativa");

      // Recebe a nova senha
      String s = scanner.next();

      for (int i = 0; i < tamSenha; i++) {
        char digito = s.charAt(i);
        tentativa[i] = (int) digito - (int) '0';
      }

      // Compara os resultados
      String resultado = comparar(tentativa, senha);

      // Testa o resultado
      if (numAcertos(resultado) == tamSenha)
        descobriu = true;
      else {
        System.out.println(resultado);
        tentativas++;
      }
    }
    return descobriu;
  }

  /**
   * Resultado da partida
   *
   * @param resultado Resultado do jogo.
   * @param senha Senha que deveria ser descoberta.
   */
  private static void imprimirResultado(boolean resultado, int[] senha) {
    if (resultado)
      System.out.println("Acertou a senha!!");
    else {
      System.out.println("Voce tentou mas nao descobriu");
      System.out.print("A senha era ");
      for (int i = 0; i < senha.length; i++)
        System.out.print(senha[i]);
      System.out.println();
    }
  }

  /**
   * Testa a jogada
   *
   * @param tentativa Jogada atual.
   * @param senha Senha que deveria ser descoberta.
   * @return O resultado da jogada.
   */
  private static String comparar(int[] tentativa, int[] senha) {
    String s = "";

    for (int i = 0; i < tentativa.length; i++)
      if (tentativa[i] != senha[i])
        s += "*";
      else
        s += tentativa[i];

    return s;
  }

  /**
   * Calcula o número de acertos na jogada
   *
   * @param resultado Resultado da jogada atual.
   * @return O numero de acertos.
   */
  private static int numAcertos(String resultado) {
    int n = 0;

    for (int i = 0; i < resultado.length(); i++)
      if (resultado.charAt(i) != '*')
        n++;

    return n;
  }
}
