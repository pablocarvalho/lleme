package exemplos;

public class Teste_2 {

  public static void main(String[] args) {
    int[] v = {}, w = {};
    int soma1 = 0, soma2 = 0;
    for (int i = 0; i < v.length; i++)
      soma1 += v[i] * w[i];

    for (int i = 0; i < v.length; i++)
      soma2 += w[i];

    System.out.println(soma1 / soma2);
  }
}
