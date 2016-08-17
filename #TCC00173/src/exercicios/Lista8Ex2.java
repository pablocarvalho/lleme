package exercicios;

public class Lista8Ex2 {

  public static void main(String[] args) {
  }

  public static float traco(float matriz[][]) {
    float traco = 0;
    for (int i = 0; i < matriz.length; i++)
      traco += matriz[i][i];
    return traco;
  }
}
