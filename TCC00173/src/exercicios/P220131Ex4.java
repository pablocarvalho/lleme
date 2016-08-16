package exercicios;

public class P220131Ex4 {

  public static void main(String[] args) {
  }

  public static float soma(float[] vet, int pos) {
    return vet[pos] + soma(vet, pos - 1);
  }
}
