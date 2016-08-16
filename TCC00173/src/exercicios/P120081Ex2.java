package exercicios;

public class P120081Ex2 {

  public static void main(String[] args) {
    float valor = 100;
    int idade = 35;
    valor = valor * (1 - desconto(valor, idade));
    System.out.println(valor);

  }

  public static float desconto(float valorConta, int idade) {
    float desconto = 0;
    if (valorConta >= 300)
      desconto = 0.25f;
    else if (valorConta >= 100 && valorConta < 300 && idade > 50)
      desconto = 0.15f;
    return desconto;
  }
}
