package exercicios;

public class P120091Ex1 {

  public static void main(String[] args) {

    float valor = 23.76f;
    float taxaPD = 1 / 2.34f;
    float taxaDR = 1.74f;

    float valorDolar = converte(valor, taxaPD);
    float valorReal = converte(valorDolar, taxaDR);

    float valorTotal = valorReal * (1 + 0.0238f);
    System.out.println(valorTotal);
  }

  public static float converte(float valor, float taxa) {
    return valor * taxa;
  }
}
