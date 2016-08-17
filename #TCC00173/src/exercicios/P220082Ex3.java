package exercicios;

public class P220082Ex3 {

  public static void main(String[] args) {
    int[] v = {2, 10, 0, 100, 4, 89};

  }

  public static int[] rodaVetor(int[] v, int k) {
    int[] r = new int[v.length];
    int novaPos;
    int tamanho = v.length;

    for (int i = 0; i < v.length; i++) {
      novaPos = i + k;
      if (novaPos >= v.length)
        novaPos -= v.length;
      r[novaPos] = v[i];
    }
    return r;
  }
}
