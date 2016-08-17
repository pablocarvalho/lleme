package exercicios;

public class Lista7Ex1 {

  public static void main(String[] args) {
    double Vetor[] = {324, 63, 233, 5, -235, -35, 35, -4};
    Vetor[0] = -1;
    int n = Vetor.length;
    double vet[] = new double[3];
    vet[0] = -2;
    vet[1] = 12;
    vet[2] = -56;
    System.out.println(negativos(Vetor));
    System.out.println(negativos(vet));
  }

  public static int negativos(double Vetor[]) {
    int contador = 0;
    for (int i = 0; i < Vetor.length; i++)
      if (Vetor[i] < 0)
        contador++;
    return contador;
  }
}
