package exemplos;

import java.util.Scanner;

public class VolumePeca {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    float h, b, e, d; /* dimensoes da peca */
    float v, s; /* volume e area da superficie */

    /* captura valores fornecidos via teclado */
    System.out.println("Entre com a altura: ");
    h = in.nextFloat();
    System.out.println("Entre com a base: ");
    b = in.nextFloat();
    System.out.println("Entre com a espessura: ");
    e = in.nextFloat();
    System.out.println("Entre com o diametro dos furos: ");
    d = in.nextFloat();

    /* calculo do volume da peca */
    v = volume_caixa(b, h, e) + volume_caixa(b - e, b, e) - 2
            * volume_cilindro(d / 2, e);

    /* calculo da area da superficie externa */
    s = area_caixa(b, h, e) + area_caixa(b, b - e, e) + 2 * area_cilindro(d / 2, e)
            - 2 * area_retangulo(b, e) - 4 * area_circulo(d / 2);

    /* exibe na tela os valores capturados */
    System.out.println("Volume e area: " + v);
  }

  public static float volume_cilindro(float raio, float altura) {
    float v;
    v = (float) Math.PI * raio * raio * altura;
    return v;
  }

  public static float volume_caixa(float a, float b, float c) {
    return a * b * c;
  }

  public static float area_caixa(float a, float b, float c) {
    return 2 * (a * b + b * c + c * a);
  }

  public static float area_cilindro(float r, float h) {
    return 2 * (float) Math.PI * r * h;
  }

  public static float area_retangulo(float a, float b) {
    return a * b;
  }

  public static float area_circulo(float r) {
    return (float) Math.PI * r * r;
  }
}
