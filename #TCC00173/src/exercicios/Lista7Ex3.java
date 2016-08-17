package exercicios;

public class Lista7Ex3 {

  public static void main(String[] args) {
    float vet[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(maiores(vet, 5));
  }

  public static int maiores(float vet[], float x) {
    int contador = 0;
    for (int i = 0; i < vet.length; i++)
      if (vet[i] > x)
        contador++;
    return contador;
  }
}
