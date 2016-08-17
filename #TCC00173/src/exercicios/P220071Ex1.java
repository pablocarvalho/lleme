/*
 * Escreva um programa que capture do teclado o numero de dias decorrido em um
 * evento e exiba na tela o mesmo valor expresso em numero de semanas e numero
 * de dias. Por exemplo, se um usuario fornecer o valor 17, o programa deve
 * imprimir 2 e 3, pois 17 dias correspondem a 2 semanas e 3 dias.
 */
package exercicios;

public class P220071Ex1 {

  public static void main(String[] args) {
    float n = 17, semanas, dias;
    semanas = (int) n / 7;
    dias = n % 7;
    System.out.println(semanas + "semanas e " + dias + " dias");
  }
}
