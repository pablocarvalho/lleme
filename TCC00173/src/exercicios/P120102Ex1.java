package exercicios;

public class P120102Ex1 {

  public static void main(String[] args) {
    float volumeA = 10.5f, volumeB = 5.7f, qtdDesejada = 12.0f;
    float maxA, maxB, percentA = 0.2f, percentB = 0.1f;

    maxA = volumeA * (1 - percentA);
    maxB = volumeB * (1 - percentB);

    if (qtdDesejada <= maxA) {
      System.out.println("extrair " + qtdDesejada + " de A");
      System.out.println("extrair 0 de B");
    } else if (qtdDesejada - maxA <= maxB) {
      System.out.println("extrair " + maxA + " de A");
      System.out.println("extrair " + (qtdDesejada - maxA) + " de B");
    } else {
      System.out.println("extrair " + maxA + " de A");
      System.out.println("extrair " + maxB + " de B");
      System.out.println("falta " + (qtdDesejada - maxA - maxB));
    }

  }
}
