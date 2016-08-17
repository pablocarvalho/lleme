package exercicios;

public class P420081Ex4 {

  public static void main(String[] args) {
    int vet[] = {1, 5, 0, 2, 7};
    graficoBarras(vet);
  }

  public static void graficoBarras(int h[]) {
    int maior = h[0];
    for (int i = 1; i < h.length; i++)
      if (h[i] > maior)
        maior = h[i];
    int matriz[][] = new int[maior][h.length];
    for (int j = 0; j < matriz[0].length; j++)
      for (int i = matriz.length - 1; i >= 0 && (matriz.length - i) <= h[j]; i--)
        if ((j % 2) == 0)
          matriz[i][j] = 2;
        else
          matriz[i][j] = 1;
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[0].length; j++)
        System.out.print(matriz[i][j] + " ");
      System.out.println("");
    }
  }
}
