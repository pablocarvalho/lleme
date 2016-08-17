package provas.s20112;

public class Extra20112 {

  public static void main(String[] args) {
    int[] vetor1 = {-1, 1, 5, 23, 23, 100};
    int[] vetor2 = {10, 34, 80, 88, 110};

    int[] vetor3 = merge(vetor1, vetor2);
    for (int numero : vetor3)
      System.out.print(numero + "\t");

  }

  public static int[] merge(int[] vet1, int[] vet2) {
    int[] resultado = new int[vet1.length + vet2.length];
    int j = 0, k = 0;
    for (int i = 0; i < resultado.length; i++)
      if (j < vet1.length && k < vet2.length)
        if (vet1[j] < vet2[k])
          resultado[i] = vet1[j++];
        else
          resultado[i] = vet2[k++];
      else if (j >= vet1.length)
        resultado[i] = vet2[k++];
      else
        resultado[i] = vet1[j++];
    return resultado;
  }
}
