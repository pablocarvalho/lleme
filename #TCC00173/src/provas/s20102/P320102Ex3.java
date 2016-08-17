package provas.s20102;

public class P320102Ex3 {

  public static void main(String[] args) {
    int v[] = {1, 3, 67};
    System.out.println(somaVetor2(v, 0));
  }

  public static int somaVetor(int vetor[], int posicao) {
    if (posicao < vetor.length)
      return vetor[posicao] + somaVetor(vetor, posicao + 1);
    return 0;
  }

  public static int somaVetor2(int vetor[], int posicao) {
    int soma;
    if (posicao >= vetor.length)
      return 0;
    else {
      soma = vetor[posicao];
      soma += somaVetor(vetor, posicao + 1);
    }
    return soma;
  }
}
