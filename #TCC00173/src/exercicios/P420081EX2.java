package exercicios;

public class P420081EX2 {

  public static void main(String[] args) {
    int vet[] = {23, 25, 13, 10, 8, 20};
    int matriz[][] = {{7, 10, 5, 10}, {5, 6, 11, 0}, {1, 0, 5, 0}, {6, 4, 6, 6}, {5, 1, 3, 7}, {6, 6, 4, 4}};
    int soma = 0;
    int contador = 0;
    for (int i = 0; i < matriz.length; i++) {
      soma = 0;
      for (int j = 0; j < 4; j++)
        soma = soma + matriz[i][j];
      if (vet[i] < soma)
        contador++;
    }
    System.out.println(contador);
  }
}
