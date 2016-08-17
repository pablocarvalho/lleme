package exercicios;

public class P120072Ex2_2 {

  public static void main(String[] args) {
    float valorProduto = 75;
    int numeroParcelas = 0;
    float juros = 0.01f;

    if (numeroParcelas > 1)
      valorProduto *= Math.pow(1 + juros, numeroParcelas);
    else
      valorProduto *= 0.95;

    System.out.println(valorProduto);

    Math.pow(Math.PI, 2);
  }
}
