package exercicios;

public class P220071Ex5 {

  public static void main(String[] args) {
  }

  public static float valormed(float vet[]) throws Exception {
    if (vet.length == 0)
      throw new Exception("");
    float maior = vet[0], menor = vet[0];
    for (int i = 1; i < vet.length; i++)
      if (vet[i] < menor)
        menor = vet[i];
      else if (vet[i] > maior)
        maior = vet[i];
    return (maior + menor) / 2;
  }
}
