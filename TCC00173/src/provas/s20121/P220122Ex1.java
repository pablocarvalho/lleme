package provas.s20121;

public class P220122Ex1 {

  public static void main(String[] args) {
    for (int i = 0; i < 20; i++)
      System.out.println(converte(i));
  }

  public static int converte(int numero) {
    if (numero > 1)
      return converte(numero / 2) * 10 + (numero % 2);
    return numero;
  }
}
