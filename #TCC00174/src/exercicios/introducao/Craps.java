package exercicios.introducao;

/**
 * Programacao de computadores II TCC-00174 Aula 1 - Introducao ao Java,
 * Exercícios. Jogo de Dados - Craps
 *
 * @author Prof. Anselmo Montenegro & Prof. Marcos Lage
 */
import java.util.Random;

public class Craps {
  // Gerador de numeros aleatorios

  private Random randomNumbers = new Random();

  // Status do jogo
  private enum Status {

    CONTINUE, WON, LOST
  };
  // Resultado da jogada
  private final static int SNAKE_EYES = 2;
  private final static int TREY = 3;
  private final static int SEVEN = 7;
  private final static int YO_LEVEN = 11;
  private final static int BOX_CARS = 12;

  /**
   * Jogo
   */
  public void play() {
    // Seu ponto
    int myPoint = 0;
    // Status do jogo
    Status gameStatus;

    // Primeira rodada
    int sumOfDice = rollDice();

    // Analise do resultado
    switch (sumOfDice) {
      case SEVEN:
      case YO_LEVEN:
        gameStatus = Status.WON;
        break;
      case SNAKE_EYES:
      case TREY:
      case BOX_CARS:
        gameStatus = Status.LOST;
        break;
      default:
        gameStatus = Status.CONTINUE;
        myPoint = sumOfDice;
        System.out.printf("Point is %d\n", myPoint);
        break;
    }

    // Rodadas seguintes
    while (gameStatus == Status.CONTINUE) {
      sumOfDice = rollDice();

      if (sumOfDice == myPoint)
        gameStatus = Status.WON;
      else if (sumOfDice == SEVEN)
        gameStatus = Status.LOST;
    }

    // Resultado final
    if (gameStatus == Status.WON)
      System.out.println("Player Wins");
    else
      System.out.println("Player Loses");

  }

  /**
   * Aremesso dos dados
   *
   * @return a soma dos valores sorteados em cada dado
   */
  public int rollDice() {
    // primeiro arremesso
    int die1 = 1 + randomNumbers.nextInt(6);
    // segundo arremesso arremesso
    int die2 = 1 + randomNumbers.nextInt(6);
    // Soma dos arremessos
    int sum = die1 + die2;

    System.out.printf("Player rolled %d + %d = %d\n", die1, die2, sum);

    return sum;
  }
}
