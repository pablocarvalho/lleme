package exercicios;

public class P220072Ex3 {

  public static void main(String[] args) {
    float v[] = new float[4];
    float w[] = new float[4];
    for (int i = 0; i <= 3; i++)
      v[i] = (float) (9 * (Math.random()));
    acumule(v, w);
    mostraVetor(v);
    System.out.println("");
    mostraVetor(w);


  }

  public static void acumule(float v[], float w[]) {
    v[0] = w[0];
    for (int i = 1; i < v.length; i++)
      w[i] = w[i - 1] + v[i];

  }

  public static void mostraVetor(float v[]) {
    for (int i = 0; i < v.length; i++)
      System.out.print(v[i] + ",");
  }
}
